package semester1.practice05;


public class Ex33 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = {{-4, 7, 2, 1}, {3, -9, 20, 5}, {8, 6, -2, 4}};
    int max = matrix[0][0], maxRow = 0, maxCol = 0;
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] > max) {
          max = matrix[row][col];
          maxRow = row;
          maxCol = col;
        }
      }
    }
    System.out.println("Максимум: " + max + " у комірці [" + maxRow + ", " + maxCol + "]");
  }
}
