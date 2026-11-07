package semester1.practice02;

import java.util.Locale;

public final class Ex21 {
  private Ex21() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 21 ---%n");
    int counter = 5;
    System.out.println("Значення виразу counter++: " + counter++);
    System.out.println("Після інкременту: " + counter);
  }
}
