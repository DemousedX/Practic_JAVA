package semester1.practice05;


public class Ex25 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = new int[3][4];
    int counter = 1;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = counter++;
      }
    }
    for (int[] row : matrix) {
      for (int value : row) {
        System.out.printf("%4d", value);
      }
      System.out.println();
    }
  }
}
