package semester1.practice02;

import java.util.Locale;

public final class Ex16 {
  private Ex16() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 16 ---%n");
    String language = "Java";
    int level = 1;
    boolean isReady = true;
    System.out.println(
        "Мова: " + language + " | Рівень: " + level + " | Готовність до практики: " + isReady);
  }
}
