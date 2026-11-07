package semester1.practice02;

import java.util.Locale;

public final class Ex39 {
  private Ex39() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 39 ---%n");
    int min = -10, max = 35, randomTemp = (int) (Math.random() * (max - min + 1)) + min;
    System.out.println("Погода на завтра: " + randomTemp + " deg C");
  }
}
