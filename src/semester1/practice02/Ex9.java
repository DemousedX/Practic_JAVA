package semester1.practice02;

import java.util.Locale;

public final class Ex9 {
  private Ex9() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 09 ---%n");
    int firstNumber = 5;
    double userWeight = 72.5;
    String userCity = "Kyiv";
    boolean isValidUser = true;
    System.out.println(firstNumber + ", " + userWeight + ", " + userCity + ", " + isValidUser);
  }
}
