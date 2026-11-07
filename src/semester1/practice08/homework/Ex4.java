package semester1.practice08.homework;

import java.util.Arrays;

public final class Ex4 {
  private Ex4() {}

  private static class Matrix2D {
    protected double[][] data;
    private final int rows, cols;

    Matrix2D(double[][] source) {
      if (source.length == 0 || source[0].length == 0)
        throw new IllegalArgumentException("Матриця порожня");
      rows = source.length;
      cols = source[0].length;
      data = new double[rows][cols];
      for (int i = 0; i < rows; i++) {
        if (source[i].length != cols)
          throw new IllegalArgumentException("Рядки матриці мають бути однакової довжини");
        data[i] = source[i].clone();
      }
    }

    int getRows() {
      return rows;
    }

    int getCols() {
      return cols;
    }

    double getElement(int r, int c) {
      return data[r][c];
    }

    void setElement(int r, int c, double value) {
      if (r < 0 || r >= rows || c < 0 || c >= cols) throw new IndexOutOfBoundsException();
      data[r][c] = value;
    }

    double getSum() {
      double sum = 0;
      for (double[] row : data) for (double x : row) sum += x;
      return sum;
    }

    double getMaxElement() {
      double max = Double.NEGATIVE_INFINITY;
      for (double[] row : data) for (double x : row) max = Math.max(max, x);
      return max;
    }

    @Override
    public String toString() {
      StringBuilder out = new StringBuilder();
      for (double[] row : data) {
        out.append("[ ");
        for (double x : row) out.append(String.format("%8.2f ", x));
        out.append("]%n".formatted());
      }
      return out.toString();
    }
  }

  private static class SquareMatrix extends Matrix2D {
    SquareMatrix(double[][] source) {
      super(source);
      if (getRows() != getCols())
        throw new IllegalArgumentException("Матриця має бути квадратною");
    }

    int getDimension() {
      return getRows();
    }

    double getTrace() {
      double sum = 0;
      for (int i = 0; i < getDimension(); i++) sum += data[i][i];
      return sum;
    }

    boolean isSymmetric() {
      for (int i = 0; i < getDimension(); i++)
        for (int j = i + 1; j < getDimension(); j++) if (data[i][j] != data[j][i]) return false;
      return true;
    }

    double getDeterminant() {
      int n = getDimension();
      if (n == 1) return data[0][0];
      if (n == 2) return data[0][0] * data[1][1] - data[0][1] * data[1][0];
      if (n == 3)
        return data[0][0] * data[1][1] * data[2][2]
            + data[0][1] * data[1][2] * data[2][0]
            + data[0][2] * data[1][0] * data[2][1]
            - data[0][2] * data[1][1] * data[2][0]
            - data[0][1] * data[1][0] * data[2][2]
            - data[0][0] * data[1][2] * data[2][1];
      return 0;
    }

    @Override
    public String toString() {
      return super.toString()
          + String.format(
              "Trace=%.2f | Symmetric=%s | det=%.2f%n",
              getTrace(), isSymmetric(), getDeterminant());
    }
  }

  private static final class CramerMatrixSolver extends SquareMatrix {
    private final double[] freeTerms;

    CramerMatrixSolver(double[][] a, double[] b) {
      super(a);
      if (b.length != getDimension())
        throw new IllegalArgumentException("Розмір вектора B не збігається");
      freeTerms = b.clone();
    }

    double[] solve() {
      double det = getDeterminant();
      if (Math.abs(det) < 1e-9) return new double[0];
      double[] roots = new double[getDimension()];
      for (int c = 0; c < roots.length; c++) {
        double[][] copy = new double[getDimension()][getDimension()];
        for (int r = 0; r < roots.length; r++) copy[r] = data[r].clone();
        for (int r = 0; r < roots.length; r++) copy[r][c] = freeTerms[r];
        roots[c] = new SquareMatrix(copy).getDeterminant() / det;
      }
      return roots;
    }

    @Override
    public String toString() {
      return "A="
          + super.toString()
          + "B="
          + Arrays.toString(freeTerms)
          + " x="
          + Arrays.toString(solve());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    SquareMatrix m = new SquareMatrix(new double[][] {{2, 1, 0}, {1, 3, 1}, {0, 1, 2}});
    System.out.println(m);
    CramerMatrixSolver system =
        new CramerMatrixSolver(new double[][] {{2, 3}, {4, -1}}, new double[] {8, 2});
    System.out.println(system);
  }
}
