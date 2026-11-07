package semester1.practice05;

import java.util.Arrays;

public class Ex29 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = new int[4][4];
    for (int[] row : matrix) {
      Arrays.fill(row, 1);
    }
    Arrays.fill(matrix[1], 0);
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][2] = 7;
    }
    for (int[] row : matrix) {
      for (int value : row) {
        System.out.printf("%4d", value);
      }
      System.out.println();
    }
  }
}
