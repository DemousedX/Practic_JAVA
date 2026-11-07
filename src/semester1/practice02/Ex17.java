package semester1.practice02;

import java.util.Locale;

public final class Ex17 {
  private Ex17() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 17 ---%n");
    int number = 19, remainder = number % 2;
    System.out.println("Число " + number + " при діленні на 2 дає остачу: " + remainder);
  }
}
