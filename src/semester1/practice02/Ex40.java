package semester1.practice02;

import java.util.Locale;

public final class Ex40 {
  private Ex40() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 40 ---%n");
    double principal = 10_000, rate = 12;
    int years = 3;
    double total = principal * Math.pow(1 + rate / 100, years), profit = total - principal;
    System.out.println("+------------------------------------+");
    System.out.println("|       ДЕПОЗИТНИЙ КАЛЬКУЛЯТОР       |");
    System.out.println("+------------------------------------+");
    System.out.printf("Початкова сума: %.2f грн%n", principal);
    System.out.printf("Термін: %d роки під %.1f%% річних%n", years, rate);
    System.out.printf("Підсумкова сума: %.2f грн%n", total);
    System.out.printf("Чистий прибуток: %.2f грн%n", profit);
    System.out.println("+------------------------------------+");
  }
}
