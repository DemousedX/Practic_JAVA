package semester1.practice02;

import java.util.Locale;

public final class Ex30 {
  private Ex30() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 30 ---%n");
    int number = 30;
    boolean isDivisibleByBoth = number % 3 == 0 && number % 5 == 0;
    System.out.println(number + " ділиться на 3 і 5: " + isDivisibleByBoth);
    number = 25;
    isDivisibleByBoth = number % 3 == 0 && number % 5 == 0;
    System.out.println(number + " ділиться на 3 і 5: " + isDivisibleByBoth);
  }
}
