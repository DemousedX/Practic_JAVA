package semester1.practice02;

import java.util.Locale;

public final class Ex33 {
  private Ex33() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 33 ---%n");
    double a = 3.0, b = 4.0, c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    System.out.println("Катети: " + a + " та " + b + ". Гіпотенуза: " + c);
  }
}
