package semester1.practice09.homework;

import java.util.Arrays;

public final class Ex4 {
  private Ex4() {}

  private static final class Matrix {
    private final double[][] data;

    Matrix(double[][] values) {
      if (values == null || values.length == 0 || values[0].length == 0)
        throw new IllegalArgumentException("Матриця порожня");
      data = new double[values.length][];
      int columns = values[0].length;
      for (int r = 0; r < values.length; r++) {
        if (values[r] == null || values[r].length != columns)
          throw new IllegalArgumentException("Некоректні рядки матриці");
        data[r] = values[r].clone();
      }
    }

    int getRows() {
      return data.length;
    }

    int getCols() {
      return data[0].length;
    }

    double get(int r, int c) {
      return data[r][c];
    }

    boolean isSquare() {
      return getRows() == getCols();
    }

    double[][] copy() {
      double[][] result = new double[data.length][];
      for (int i = 0; i < data.length; i++) result[i] = data[i].clone();
      return result;
    }

    Matrix transpose() {
      double[][] result = new double[getCols()][getRows()];
      for (int r = 0; r < getRows(); r++)
        for (int c = 0; c < getCols(); c++) result[c][r] = data[r][c];
      return new Matrix(result);
    }

    Matrix scale(double factor) {
      double[][] result = copy();
      for (int r = 0; r < getRows(); r++)
        for (int c = 0; c < getCols(); c++) result[r][c] *= factor;
      return new Matrix(result);
    }

    Matrix shift(double amount) {
      double[][] result = copy();
      for (int i = 0; i < Math.min(getRows(), getCols()); i++) result[i][i] += amount;
      return new Matrix(result);
    }

    Matrix multiply(Matrix right) {
      double[][] result = new double[getRows()][right.getCols()];
      for (int r = 0; r < getRows(); r++)
        for (int c = 0; c < right.getCols(); c++)
          for (int k = 0; k < getCols(); k++) result[r][c] += get(r, k) * right.get(k, c);
      return new Matrix(result);
    }

    double frobeniusNorm() {
      double sum = 0;
      for (double[] row : data) for (double value : row) sum += value * value;
      return Math.sqrt(sum);
    }

    double determinant() {
      if (!isSquare()) throw new IllegalStateException("Матриця має бути квадратною");
      if (getRows() == 1) return data[0][0];
      double result = 0;
      for (int c = 0; c < getCols(); c++) {
        double[][] minor = new double[getRows() - 1][getCols() - 1];
        for (int r = 1; r < getRows(); r++) {
          int k = 0;
          for (int j = 0; j < getCols(); j++) if (j != c) minor[r - 1][k++] = data[r][j];
        }
        result += (c % 2 == 0 ? 1 : -1) * data[0][c] * new Matrix(minor).determinant();
      }
      return result;
    }

    @Override
    public String toString() {
      return Arrays.deepToString(data);
    }
  }

  private abstract static class Operator {
    private final String name;

    Operator(String name) {
      this.name = name;
    }

    abstract boolean isApplicable(Matrix input);

    abstract Matrix apply(Matrix input);

    final Matrix executeSafely(Matrix input) {
      if (input == null || !isApplicable(input)) {
        System.out.println("Оператор " + name + " пропущено: несумісна матриця");
        return input;
      }
      return apply(input);
    }

    @Override
    public String toString() {
      return name;
    }
  }

  private static final class Scale extends Operator {
    private final double factor;

    Scale(double f) {
      super("Scale(" + f + ")");
      factor = f;
    }

    boolean isApplicable(Matrix m) {
      return true;
    }

    Matrix apply(Matrix m) {
      return m.scale(factor);
    }
  }

  private static final class Transpose extends Operator {
    Transpose() {
      super("Transpose");
    }

    boolean isApplicable(Matrix m) {
      return true;
    }

    Matrix apply(Matrix m) {
      return m.transpose();
    }
  }

  private static final class DiagonalShift extends Operator {
    private final double lambda;

    DiagonalShift(double n) {
      super("DiagonalShift(" + n + ")");
      lambda = n;
    }

    boolean isApplicable(Matrix m) {
      return m.isSquare();
    }

    Matrix apply(Matrix m) {
      return m.shift(lambda);
    }
  }

  private static final class Multiply extends Operator {
    private final Matrix right;

    Multiply(Matrix m) {
      super("Multiply");
      right = m;
    }

    boolean isApplicable(Matrix m) {
      return m.getCols() == right.getRows();
    }

    Matrix apply(Matrix m) {
      return m.multiply(right);
    }
  }

  private static final class MatrixPipeline {
    private final String name;
    private final Operator[] stages;
    private int count;

    MatrixPipeline(String n, int capacity) {
      name = n;
      stages = new Operator[capacity];
    }

    void addStage(Operator op) {
      if (op != null && count < stages.length) stages[count++] = op;
    }

    Matrix runPipeline(Matrix initial) {
      Matrix result = initial;
      System.out.println(name + ": " + result);
      for (int i = 0; i < count; i++) {
        result = stages[i].executeSafely(result);
        System.out.println("Stage " + (i + 1) + " " + stages[i] + ": " + result);
      }
      return result;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    double[][] values = {{1, 2}, {3, 4}};
    Matrix original = new Matrix(values);
    values[0][0] = 999;
    MatrixPipeline pipeline = new MatrixPipeline("Matrix pipeline", 4);
    pipeline.addStage(new Scale(2));
    pipeline.addStage(new Transpose());
    pipeline.addStage(new DiagonalShift(3));
    pipeline.addStage(new Multiply(new Matrix(new double[][] {{1, 0}, {0, 1}})));
    pipeline.runPipeline(original);
    System.out.printf(
        "Frobenius norm=%.2f, det=%.2f%n", original.frobeniusNorm(), original.determinant());
  }
}
