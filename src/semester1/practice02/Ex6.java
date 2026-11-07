package semester1.practice02;

import java.util.Locale;

public final class Ex6 {
  private Ex6() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 06 ---%n");
    final double GRAVITY = 9.81;
    final int DAYS_IN_WEEK = 7;
    final String UNIVERSITY_NAME = "Львівська Політехніка";
    System.out.println(GRAVITY);
    System.out.println(DAYS_IN_WEEK);
    System.out.println(UNIVERSITY_NAME);
  }
}
