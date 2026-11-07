package semester1.practice05;


public class Ex30 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int sum = 0, count = 0;
    for (int[] row : matrix) {
      for (int n : row) {
        sum += n;
        count++;
      }
    }
    System.out.println(
        "Сума: " + sum + ", кількість: " + count + ", середнє: " + (double) sum / count);
  }
}
