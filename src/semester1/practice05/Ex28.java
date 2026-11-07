package semester1.practice05;


public class Ex28 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = new int[5][5];
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][i] = 1;
    }
    for (int[] row : matrix) {
      for (int value : row) {
        System.out.printf("%4d", value);
      }
      System.out.println();
    }
  }
}
