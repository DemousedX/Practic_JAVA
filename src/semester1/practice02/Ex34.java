package semester1.practice02;

import java.util.Locale;

public final class Ex34 {
  private Ex34() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 34 ---%n");
    double radius = 5.0;
    System.out.println("Радіус: " + radius);
    System.out.println("Довжина кола: " + (2 * Math.PI * radius));
    System.out.println("Площа круга: " + (Math.PI * Math.pow(radius, 2)));
  }
}
