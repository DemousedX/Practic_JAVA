package semester1.practice02;

import java.util.Locale;

public final class Ex35 {
  private Ex35() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 35 ---%n");
    double dayTemp = 18.5, nightTemp = -3.2;
    System.out.println("Перепад: " + Math.abs(dayTemp - nightTemp));
    System.out.println("Максимум: " + Math.max(dayTemp, nightTemp));
    System.out.println("Мінімум: " + Math.min(dayTemp, nightTemp));
  }
}
