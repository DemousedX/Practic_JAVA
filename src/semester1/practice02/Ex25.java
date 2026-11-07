package semester1.practice02;

import java.util.Locale;

public final class Ex25 {
  private Ex25() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 25 ---%n");
    int userAge = 17;
    boolean isAdult = userAge >= 18;
    System.out.println("Вік: " + userAge + ". Чи є повнолітнім: " + isAdult);
  }
}
