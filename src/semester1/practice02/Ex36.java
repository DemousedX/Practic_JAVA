package semester1.practice02;

import java.util.Locale;

public final class Ex36 {
  private Ex36() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 36 ---%n");
    for (double num : new double[] {5.67, -5.67})
      System.out.printf(
          "%s: round=%d, ceil=%.1f, floor=%.1f%n",
          num, Math.round(num), Math.ceil(num), Math.floor(num));
  }
}
