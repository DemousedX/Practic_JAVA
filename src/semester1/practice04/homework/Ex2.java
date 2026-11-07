package semester1.practice04.homework;

import java.util.Scanner;

public final class Ex2 {
  private Ex2() {}

  private static void digits(Scanner s) {
    int original;
    do {
      original = read(s, "Додатне число: ");
    } while (original <= 0);
    int temp = original, rev = 0, sum = 0, count = 0, max = 0;
    while (temp > 0) {
      int digit = temp % 10;
      rev = rev * 10 + digit;
      sum += digit;
      max = Math.max(max, digit);
      count++;
      temp /= 10;
    }
    System.out.printf(
        "Число %d: цифр %d, сума %d, найбільша %d, реверс %d.%n%s%n",
        original, count, sum, max, rev, original == rev ? "Паліндром!" : "Звичайне число");
  }

  private static int read(Scanner s, String p) {
    System.out.print(p);
    while (!s.hasNextInt()) {
      System.out.println("Введіть ціле число");
      s.next();
      System.out.print(p);
    }
    return s.nextInt();
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N4, завдання 2 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      digits(s);
    }
  }
}
