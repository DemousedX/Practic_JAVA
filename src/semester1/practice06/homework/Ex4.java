package semester1.practice06.homework;

public final class Ex4 {
  private Ex4() {}

  private static void matrix() {
    MatrixSolver m = new MatrixSolver();
    m.setMatrix(new double[][] {{2, 1}, {5, 3}});
    m.printMatrix();
    double[] result = m.solveCramer(9, 24);
    System.out.printf("D=%.1f; x=%.2f, y=%.2f%n", m.determinant2x2(), result[0], result[1]);
    m.setMatrix(new double[][] {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}});
    System.out.println("det 3x3 = " + m.determinant3x3());
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N6, завдання 4 ---%n");
    matrix();
  }
}
