package semester1.practice02;

import java.util.Locale;

public final class Ex19 {
  private Ex19() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 19 ---%n");
    int n = 47, tens = n / 10, units = n % 10;
    System.out.println(
        "Число: "
            + n
            + ". Десятки: "
            + tens
            + ", Одиниці: "
            + units
            + ". Сума цифр: "
            + (tens + units));
  }
}
