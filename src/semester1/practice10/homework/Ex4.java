package semester1.practice10.homework;

public class Ex4 {

  public static final class ImmutableMatrix2D {
    private final int rows, cols;
    private final double[][] data;

    ImmutableMatrix2D(double[][] source) {
      if (source == null || source.length == 0 || source[0] == null || source[0].length == 0)
        throw new IllegalArgumentException("Порожня матриця");
      rows = source.length;
      cols = source[0].length;
      data = new double[rows][cols];
      for (int i = 0; i < rows; i++) {
        if (source[i] == null || source[i].length != cols)
          throw new IllegalArgumentException("Матриця має бути прямокутною");
        for (int j = 0; j < cols; j++) {
          if (!Double.isFinite(source[i][j]))
            throw new IllegalArgumentException("Некоректний елемент");
          data[i][j] = source[i][j];
        }
      }
    }

    public int getRows() {
      return rows;
    }

    public int getCols() {
      return cols;
    }

    public double get(int r, int c) {
      return data[r][c];
    }

    public double[][] getDataCopy() {
      double[][] copy = new double[rows][];
      for (int i = 0; i < rows; i++) copy[i] = java.util.Arrays.copyOf(data[i], cols);
      return copy;
    }

    public double getTrace() {
      if (rows != cols) throw new IllegalStateException("Потрібна квадратна матриця");
      double sum = 0;
      for (int i = 0; i < rows; i++) sum += data[i][i];
      return sum;
    }

    public double getFrobeniusNorm() {
      double norm = 0;
      for (double[] row : data) for (double value : row) norm = Math.hypot(norm, value);
      return norm;
    }

    public double getDeterminant() {
      if (rows == 2 && cols == 2) return data[0][0] * data[1][1] - data[0][1] * data[1][0];
      if (rows == 3 && cols == 3)
        return data[0][0] * (data[1][1] * data[2][2] - data[1][2] * data[2][1])
            - data[0][1] * (data[1][0] * data[2][2] - data[1][2] * data[2][0])
            + data[0][2] * (data[1][0] * data[2][1] - data[1][1] * data[2][0]);
      throw new IllegalStateException("Визначник підтримується для 2x2 та 3x3");
    }

    public double maxAbsDifference(ImmutableMatrix2D other) {
      if (rows != other.rows || cols != other.cols)
        throw new IllegalArgumentException("Розміри не збігаються");
      double max = 0;
      for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++) max = Math.max(max, Math.abs(data[i][j] - other.data[i][j]));
      return max;
    }

    @Override
    public String toString() {
      StringBuilder out = new StringBuilder();
      for (double[] row : data)
        out.append(java.util.Arrays.toString(row)).append(System.lineSeparator());
      return out.toString();
    }
  }

  interface InvertibleOperator {
    ImmutableMatrix2D applyInverse(ImmutableMatrix2D transformed);
  }

  interface OrthogonalOperator extends InvertibleOperator {
    default boolean verifyNormInvariance(ImmutableMatrix2D before, ImmutableMatrix2D after) {
      return Math.abs(before.getFrobeniusNorm() - after.getFrobeniusNorm()) < 1e-6;
    }
  }

  abstract static class AbstractMatrixOperator {
    private final String operatorName;

    AbstractMatrixOperator(String name) {
      operatorName = name;
    }

    public String getOperatorName() {
      return operatorName;
    }

    public abstract boolean canApply(ImmutableMatrix2D m);

    protected abstract ImmutableMatrix2D transform(ImmutableMatrix2D m);

    public final ImmutableMatrix2D execute(ImmutableMatrix2D m) {
      if (m == null || !canApply(m))
        throw new IllegalArgumentException("Оператор не підтримує матрицю");
      ImmutableMatrix2D result = transform(m);
      if (this instanceof OrthogonalOperator ort && !ort.verifyNormInvariance(m, result))
        throw new IllegalStateException("Норма не збережена");
      return result;
    }
  }

  static class NonZeroScaleOperator extends AbstractMatrixOperator implements InvertibleOperator {
    private final double factor;

    NonZeroScaleOperator(double factor) {
      super("Масштаб x" + factor);
      if (!Double.isFinite(factor) || factor == 0)
        throw new IllegalArgumentException("Потрібен ненульовий скаляр");
      this.factor = factor;
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
      return m != null;
    }

    private ImmutableMatrix2D multiply(ImmutableMatrix2D m, double k) {
      double[][] result = m.getDataCopy();
      for (double[] row : result) for (int j = 0; j < row.length; j++) row[j] *= k;
      return new ImmutableMatrix2D(result);
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
      return multiply(m, factor);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D m) {
      return multiply(m, 1 / factor);
    }
  }

  static class TransposeOperator extends AbstractMatrixOperator implements OrthogonalOperator {
    TransposeOperator() {
      super("Транспонування");
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
      return m != null;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
      double[][] result = new double[m.cols][m.rows];
      for (int i = 0; i < m.rows; i++) for (int j = 0; j < m.cols; j++) result[j][i] = m.get(i, j);
      return new ImmutableMatrix2D(result);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D m) {
      return execute(m);
    }
  }

  static class GivensRotationOperator extends AbstractMatrixOperator implements OrthogonalOperator {
    private final double angle;

    GivensRotationOperator(double angle) {
      super("Поворот " + Math.toDegrees(angle) + " градусів");
      if (!Double.isFinite(angle)) throw new IllegalArgumentException("Некоректний кут");
      this.angle = angle;
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
      return m != null && m.rows >= 2;
    }

    private ImmutableMatrix2D rotate(ImmutableMatrix2D m, double a) {
      if (!canApply(m)) throw new IllegalArgumentException("Потрібно щонайменше два рядки");
      double[][] result = m.getDataCopy();
      double c = Math.cos(a), s = Math.sin(a);
      for (int j = 0; j < m.cols; j++) {
        result[0][j] = c * m.get(0, j) - s * m.get(1, j);
        result[1][j] = s * m.get(0, j) + c * m.get(1, j);
      }
      return new ImmutableMatrix2D(result);
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
      return rotate(m, angle);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D m) {
      return rotate(m, -angle);
    }
  }

  static class UpperTriangularProjection extends AbstractMatrixOperator {
    UpperTriangularProjection() {
      super("Верхня трикутна проєкція");
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
      return m != null && m.rows == m.cols;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
      double[][] result = m.getDataCopy();
      for (int i = 0; i < m.rows; i++) for (int j = 0; j < i; j++) result[i][j] = 0;
      return new ImmutableMatrix2D(result);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    double[][] source = {{3, 4}, {0, 5}};
    ImmutableMatrix2D initial = new ImmutableMatrix2D(source);
    source[0][0] = 999;
    System.out.println("Початкова матриця:");
    System.out.print(initial);
    System.out.printf(
        "Норма: %.6f, слід: %.2f, det: %.2f%n",
        initial.getFrobeniusNorm(), initial.getTrace(), initial.getDeterminant());
    AbstractMatrixOperator[] pipeline = {
      new NonZeroScaleOperator(2), new TransposeOperator(), new GivensRotationOperator(Math.PI / 3)
    };
    ImmutableMatrix2D current = initial;
    for (AbstractMatrixOperator op : pipeline) {
      current = op.execute(current);
      System.out.printf(
          "%s: норма=%.6f, det=%.6f%n",
          op.getOperatorName(), current.getFrobeniusNorm(), current.getDeterminant());
    }
    System.out.println("Результат прямого проходу:");
    System.out.print(current);
    ImmutableMatrix2D projected = new UpperTriangularProjection().execute(current);
    System.out.println("Необоротна проєкція окремо:");
    System.out.print(projected);
    for (int i = pipeline.length - 1; i >= 0; i--)
      if (pipeline[i] instanceof InvertibleOperator inv) current = inv.applyInverse(current);
    System.out.println("Відновлено:");
    System.out.print(current);
    System.out.printf("Похибка відновлення: %.3e%n", initial.maxAbsDifference(current));
  }
}
