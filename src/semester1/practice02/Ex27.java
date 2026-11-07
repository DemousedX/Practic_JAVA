package semester1.practice02;

import java.util.Locale;

public final class Ex27 {
  private Ex27() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 27 ---%n");
    int speed = 75;
    boolean isSafeSpeed = speed >= 20 && speed <= 80;
    System.out.println("Швидкість " + speed + " км/год у безпечному діапазоні: " + isSafeSpeed);
  }
}
