package semester1.practice02;

import java.util.Locale;

public final class Ex8 {
  private Ex8() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 08 ---%n");
    double priceWithPennies = 49.99;
    int roundedPrice = (int) priceWithPennies;
    System.out.println("Ціна після приведення: " + roundedPrice);
  }
}
