package semester1.practice05;

import java.util.Arrays;

public class Ex38 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] pascal = new int[5][];
    for (int i = 0; i < pascal.length; i++) {
      pascal[i] = new int[i + 1];
      pascal[i][0] = pascal[i][i] = 1;
      for (int j = 1; j < i; j++) {
        pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
      }
      System.out.println(Arrays.toString(pascal[i]));
    }
  }
}
