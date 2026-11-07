package semester1.practice06.homework;

public final class Ex3 {
  private Ex3() {}

  private static void vector() {
    Vector2D a = new Vector2D(), b = new Vector2D();
    a.set(3, 4);
    b.set(-4, 3);
    System.out.printf(
        "|A|=%.2f, |B|=%.2f, A*B=%.2f, ортогональні=%s%n",
        a.getLength(),
        b.getLength(),
        a.dotProduct(b.getX(), b.getY()),
        a.dotProduct(b.getX(), b.getY()) == 0);
    a.normalize();
    System.out.printf(
        "Нормалізований A=(%.2f, %.2f), довжина %.2f%n", a.getX(), a.getY(), a.getLength());
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N6, завдання 3 ---%n");
    vector();
  }
}
