package semester1.practice04.homework;

import java.util.Scanner;

public final class Ex3 {
  private Ex3() {}

  private static void fibonacci(Scanner s) {
    int n;
    do {
      n = read(s, "Скільки чисел Фібоначчі (3-46): ");
    } while (n < 3 || n > 46);
    int a = 1, b = 1;
    System.out.println("N1: 1\nN2: 1");
    double ratio = 1;
    for (int k = 3; k <= n; k++) {
      int next = a + b;
      ratio = (double) next / b;
      System.out.printf("N%d: %d | відношення %.6f%n", k, next, ratio);
      a = b;
      b = next;
    }
    System.out.printf("Наближення phi: %.6f (еталон 1.618034)%n", ratio);
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
    System.out.printf("%n--- ДЗ до практичної N4, завдання 3 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      fibonacci(s);
    }
  }
}
