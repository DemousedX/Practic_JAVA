package semester1.practice02;

import java.util.Locale;

public final class Ex38 {
  private Ex38() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 38 ---%n");
    int dice = (int) (Math.random() * 6) + 1;
    System.out.println("Випало на кубику: " + dice);
  }
}
