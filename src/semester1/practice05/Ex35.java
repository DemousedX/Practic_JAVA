package semester1.practice05;

import java.util.Arrays;

public class Ex35 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, transposed = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        transposed[j][i] = matrix[i][j];
      }
    }
    for (int i = 0; i < 3; i++) {
      System.out.println(Arrays.toString(matrix[i]) + " | " + Arrays.toString(transposed[i]));
    }
  }
}
