package semester1.practice02;

import java.util.Locale;

public final class Ex37 {
  private Ex37() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 37 ---%n");
    double a = 1, b = -7, c = 10, d = Math.pow(b, 2) - 4 * a * c;
    double x1 = (-b + Math.sqrt(d)) / (2 * a), x2 = (-b - Math.sqrt(d)) / (2 * a);
    System.out.println("Дискримінант D = " + d);
    System.out.println("Корінь x1 = " + x1);
    System.out.println("Корінь x2 = " + x2);
  }
}
