package semester1.practice02;

import java.util.Locale;

public final class Ex28 {
  private Ex28() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 28 ---%n");
    int personAge = 70;
    boolean hasFreePass = personAge < 7 || personAge >= 65;
    System.out.println("Вік: " + personAge + ". Право на безкоштовний проїзд: " + hasFreePass);
  }
}
