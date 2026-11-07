package semester1.practice02;

import java.util.Locale;

public final class Ex23 {
  private Ex23() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 23 ---%n");
    int grade1 = 4, grade2 = 5, grade3 = 4;
    double average = (grade1 + grade2 + grade3) / 3.0;
    System.out.println("Середній бал: " + average);
  }
}
