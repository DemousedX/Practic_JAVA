package semester1.practice02;

import java.util.Locale;

public final class Ex1 {
  private Ex1() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 01 ---%n");
    int age = 18;
    double height = 1.78;
    char firstLetter = 'О';
    boolean isStudent = true;
    System.out.println(age);
    System.out.println(height);
    System.out.println(firstLetter);
    System.out.println(isStudent);
  }
}
