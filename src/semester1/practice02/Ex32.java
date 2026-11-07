package semester1.practice02;

import java.util.Locale;

public final class Ex32 {
  private Ex32() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 32 ---%n");
    int year = 2024;
    boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    System.out.println(year + " - високосний рік: " + isLeapYear);
  }
}
