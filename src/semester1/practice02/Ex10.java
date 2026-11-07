package semester1.practice02;

import java.util.Locale;

public final class Ex10 {
  private Ex10() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 10 ---%n");
    String firstName = "Тарас", lastName = "Шевченко";
    int age = 47;
    System.out.println("Мене звати " + firstName + " " + lastName + ", мені " + age + " років");
  }
}
