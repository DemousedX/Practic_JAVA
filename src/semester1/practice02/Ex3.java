package semester1.practice02;

import java.util.Locale;

public final class Ex3 {
  private Ex3() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 03 ---%n");
    float floatValue = 1.1234567f;
    double doubleValue = 1.123456789012345;
    System.out.println("float: " + floatValue);
    System.out.println("double: " + doubleValue);
  }
}
