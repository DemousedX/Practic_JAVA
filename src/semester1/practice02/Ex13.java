package semester1.practice02;

import java.util.Locale;

public final class Ex13 {
  private Ex13() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 13 ---%n");
    String productName = "Ноутбук";
    int quantity = 2;
    double pricePerUnit = 24500.50;
    System.out.println(
        "ЧЕК:\nТовар: "
            + productName
            + "\nКількість: "
            + quantity
            + " шт.\nЦіна: "
            + pricePerUnit
            + " грн");
  }
}
