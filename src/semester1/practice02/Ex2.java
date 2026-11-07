package semester1.practice02;

import java.util.Locale;

public final class Ex2 {
  private Ex2() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 02 ---%n");
    byte temperature = -15;
    short currentYear = 2026;
    int cityPopulation = 1_200_000;
    long worldPopulation = 8_100_000_000L;
    System.out.println(temperature);
    System.out.println(currentYear);
    System.out.println(cityPopulation);
    System.out.println(worldPopulation);
  }
}
