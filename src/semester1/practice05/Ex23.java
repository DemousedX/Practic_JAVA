package semester1.practice05;


public class Ex23 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = i * 3 + j + 1;
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
