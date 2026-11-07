package semester1.practice06;

public class Ex39 {
  static class Matrix2D {
    private int[][] grid = new int[0][];

    public void setGrid(int[][] grid) {
      this.grid = new int[grid.length][];
      for (int i = 0; i < grid.length; i++) this.grid[i] = grid[i].clone();
    }

    public void printMatrix() {
      for (int[] row : grid) {
        for (int x : row) System.out.printf("%4d", x);
        System.out.println();
      }
    }

    public int getTotalSum() {
      int sum = 0;
      for (int[] row : grid) for (int x : row) sum += x;
      return sum;
    }

    public int getRowSum(int rowIndex) {
      int sum = 0;
      for (int x : grid[rowIndex]) sum += x;
      return sum;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Matrix2D m = new Matrix2D();
    m.setGrid(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    m.printMatrix();
    System.out.println(m.getTotalSum());
    System.out.println(m.getRowSum(1));
  }
}
