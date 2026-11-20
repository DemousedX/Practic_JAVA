package semester1.practice11;

import semester1.ConsoleOutput;

public class Ex5 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    testIntegerPool();
  }

  public static void testIntegerPool() {
    Integer a = 100;
    Integer b = 100;
    Integer x = 250;
    Integer y = 250;
    System.out.printf("100: == %s, equals %s%n", a == b, a.equals(b));
    System.out.printf("250: == %s, equals %s%n", x == y, x.equals(y));
    System.out.println("За типового кешу 250 має різні посилання. equals порівнює значення.");
  }
}
