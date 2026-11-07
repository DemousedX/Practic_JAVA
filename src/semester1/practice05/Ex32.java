package semester1.practice05;


public class Ex32 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    for (int[] row : matrix) {
      for (int value : row) {
        System.out.printf("%4d", value);
      }
      System.out.println();
    }
    for (int col = 0; col < matrix[0].length; col++) {
      int sum = 0;
      for (int row = 0; row < matrix.length; row++) {
        sum += matrix[row][col];
      }
      System.out.printf("%4d", sum);
    }
    System.out.println();
  }
}
