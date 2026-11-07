package semester1.practice02;

import java.util.Locale;

public final class Ex14 {
  private Ex14() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 14 ---%n");
    String currency = "UAH";
    int hryvnias = 1500, kopecks = 75;
    System.out.printf("Поточний баланс: %d.%02d %s%n", hryvnias, kopecks, currency);
  }
}
