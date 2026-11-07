package semester1.practice02;

import java.util.Locale;

public final class Ex7 {
  private Ex7() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 07 ---%n");
    int intVal = 250;
    double doubleVal = intVal;
    System.out.println("int: " + intVal);
    System.out.println("double: " + doubleVal);
  }
}
