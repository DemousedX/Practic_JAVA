package semester1.practice02;

import java.util.Locale;

public final class Ex4 {
  private Ex4() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 04 ---%n");
    char symbol1 = 'J', symbol2 = 74, symbol3 = '\u004A';
    System.out.println(symbol1);
    System.out.println(symbol2);
    System.out.println(symbol3);
  }
}
