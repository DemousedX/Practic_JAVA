package semester1.practice02;

import java.util.Locale;

public final class Ex18 {
  private Ex18() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 18 ---%n");
    int totalSeconds = 385, minutes = totalSeconds / 60, seconds = totalSeconds % 60;
    System.out.println(totalSeconds + " секунд = " + minutes + " хв " + seconds + " сек");
  }
}
