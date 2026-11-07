package semester1.practice04.homework;

import java.util.Scanner;

public final class Ex4 {
  private Ex4() {}

  private static void primes(Scanner s) {
    int n;
    do {
      n = read(s, "Верхня межа N (2-100000): ");
    } while (n < 2 || n > 100000);
    int count = 0;
    long sum = 0;
    StringBuilder list = new StringBuilder();
    for (int x = 2; x <= n; x++) {
      boolean prime = true;
      for (int d = 2; d <= x / d; d++)
        if (x % d == 0) {
          prime = false;
          break;
        }
      if (prime) {
        if (!list.isEmpty()) list.append(", ");
        list.append(x);
        sum += x;
        count++;
      }
    }
    System.out.println("Прості числа: " + list);
    int total = n - 1;
    System.out.printf(
        "Кількість: %d%nСума: %d%nЧастка: %.2f%%%n", count, sum, 100.0 * count / total);
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
    System.out.printf("%n--- ДЗ до практичної N4, завдання 4 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      primes(s);
    }
  }
}
