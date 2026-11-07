package semester1.practice05;


public class Ex34 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int main = 0, other = 0;
    for (int i = 0; i < matrix.length; i++) {
      main += matrix[i][i];
      other += matrix[i][matrix.length - 1 - i];
    }
    System.out.println("Головна: " + main + ", побічна: " + other);
    System.out.println("Рівні: " + (main == other));
  }
}
