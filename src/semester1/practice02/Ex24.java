package semester1.practice02;

import java.util.Locale;

public final class Ex24 {
  private Ex24() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 24 ---%n");
    double celsius = 25.0, fahrenheit = celsius * 1.8 + 32, kelvin = celsius + 273.15;
    System.out.println(celsius + " deg C = " + fahrenheit + " deg F");
    System.out.println(celsius + " deg C = " + kelvin + " K");
  }
}
