package semester1.practice05;

import java.util.Arrays;

public class Ex26 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = new int[4][3];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = (int) (Math.random() * 90) + 10;
      }
    }
    System.out.println(Arrays.deepToString(matrix));
    for (int[] row : matrix) {
      for (int value : row) {
        System.out.printf("%4d", value);
      }
      System.out.println();
    }
  }
}
