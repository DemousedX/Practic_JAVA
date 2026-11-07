package semester1.practice05;


public class Ex24 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] matrix = {{10, 20, 30, 40}, {50, 60, 70, 80}};
    System.out.println("Рядків: " + matrix.length + ", стовпців: " + matrix[0].length);
    System.out.println(
        matrix[0][0]
            + " "
            + matrix[0][matrix[0].length - 1]
            + " "
            + matrix[matrix.length - 1][0]
            + " "
            + matrix[matrix.length - 1][matrix[0].length - 1]);
  }
}
