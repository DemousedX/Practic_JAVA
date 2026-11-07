package semester1.practice02;

import java.util.Locale;

public final class Ex11 {
  private Ex11() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 11 ---%n");
    int a = 10, b = 20;
    System.out.println("Сума без дужок: " + a + b);
    System.out.println("Сума з дужками: " + (a + b));
  }
}
