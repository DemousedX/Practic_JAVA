package semester1.practice06.homework;

public final class Ex2 {
  private Ex2() {}

  private static void quadratic() {
    QuadraticEquation q = new QuadraticEquation();
    q.setCoefficients(1, -7, 10);
    System.out.printf(
        "D=%.2f; дійсні корені: %s; x1=%.2f; x2=%.2f%n",
        q.getDiscriminant(), q.hasRealRoots(), q.getRoot1(), q.getRoot2());
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N6, завдання 2 ---%n");
    quadratic();
  }
}
