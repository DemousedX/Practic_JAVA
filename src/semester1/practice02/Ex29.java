package semester1.practice02;

import java.util.Locale;

public final class Ex29 {
  private Ex29() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 29 ---%n");
    boolean isDoorLocked = true, canEnter = !isDoorLocked;
    System.out.println("Двері зачинені: " + isDoorLocked);
    System.out.println("Чи можна увійти: " + canEnter);
  }
}
