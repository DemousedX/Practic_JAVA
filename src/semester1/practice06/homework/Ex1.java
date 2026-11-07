package semester1.practice06.homework;

public final class Ex1 {
  private Ex1() {}

  private static void fraction() {
    Fraction f = new Fraction(8, 12);
    System.out.print("Дріб після скорочення: ");
    f.printFraction();
    System.out.printf("Десятковий вигляд: %.4f%n", f.toDecimal());
    f.add(3, 4);
    System.out.print("Після додавання 3/4: ");
    f.printFraction();
    System.out.printf("Десятковий вигляд: %.4f%n", f.toDecimal());
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N6, завдання 1 ---%n");
    fraction();
  }
}
