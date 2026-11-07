package semester1.practice06;

public class Ex40 {
  static class MatrixDiagonals {
    private int[][] matrix = new int[0][];

    public void setMatrix(int[][] matrix) {
      this.matrix = new int[matrix.length][];
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[i].length != matrix.length)
          throw new IllegalArgumentException("Потрібна квадратна матриця");
        this.matrix[i] = matrix[i].clone();
      }
    }

    public int getMainDiagonalSum() {
      int sum = 0;
      for (int i = 0; i < matrix.length; i++) sum += matrix[i][i];
      return sum;
    }

    public int getAntiDiagonalSum() {
      int sum = 0;
      for (int i = 0; i < matrix.length; i++) sum += matrix[i][matrix.length - 1 - i];
      return sum;
    }

    public boolean isDiagonalSymmetric() {
      return getMainDiagonalSum() == getAntiDiagonalSum();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    MatrixDiagonals m = new MatrixDiagonals();
    m.setMatrix(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    System.out.println(m.getMainDiagonalSum());
    System.out.println(m.getAntiDiagonalSum());
    System.out.println(m.isDiagonalSymmetric());
  }
}
