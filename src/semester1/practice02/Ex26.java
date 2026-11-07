package semester1.practice02;

import java.util.Locale;

public final class Ex26 {
  private Ex26() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 26 ---%n");
    int x = 15, y = 20;
    System.out.println("x == y: " + (x == y));
    System.out.println("x != y: " + (x != y));
    System.out.println("x > y: " + (x > y));
  }
}
