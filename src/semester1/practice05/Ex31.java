package semester1.practice05;


public class Ex31 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    int[] rowSums = new int[3];
    for (int i = 0; i < matrix.length; i++) {
      for (int n : matrix[i]) {
        rowSums[i] += n;
      }
      System.out.println("Рядок " + i + ": сума = " + rowSums[i]);
    }
  }
}
