package semester1.practice04.homework;

import java.util.Scanner;

public final class Ex1 {
  private Ex1() {}

  private static void range(Scanner s) {
    int n;
    do {
      n = read(s, "N (>0): ");
      if (n <= 0) System.out.println("N має бути додатним");
    } while (n <= 0);
    long sum = 0, even = 0, odd = 0;
    int ce = 0, co = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
      if (i % 2 == 0) {
        even += i;
        ce++;
      } else {
        odd += i;
        co++;
      }
    }
    System.out.printf(
        "Сума: %d%nПарні: %d (кількість %d)%nНепарні: %d (кількість %d)%nСереднє: %.2f%n",
        sum, even, ce, odd, co, (double) sum / n);
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
    System.out.printf("%n--- ДЗ до практичної N4, завдання 1 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      range(s);
    }
  }
}
