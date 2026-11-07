package semester1.practice03.homework;

import java.util.Scanner;

public final class Ex1 {
  private Ex1() {}

  private static void fuel(Scanner s) {
    double distance = number(s, "Відстань (км): "), consumption = number(s, "Витрата (л/100 км): ");
    int type = integer(s, "Пальне (1 А-95, 2 дизель, 3 газ): ");
    if (distance <= 0 || consumption <= 0) {
      System.out.println("Відстань і витрата мають бути додатними");
      return;
    }
    double price =
        switch (type) {
          case 1 -> 56.50;
          case 2 -> 52.80;
          case 3 -> 29.40;
          default -> -1;
        };
    if (price < 0) {
      System.out.println("Невідомий тип пального");
      return;
    }
    double liters = distance * consumption / 100,
        base = liters * price,
        discount = base >= 2000 ? base * .05 : 0,
        finalCost = base - discount;
    System.out.printf(
        "Потрібно пального: %.2f л%nБазова вартість: %.2f грн%nЗнижка: %.2f грн%nДо сплати: %.2f"
            + " грн%n",
        liters, base, discount, finalCost);
  }

  private static int integer(Scanner s, String prompt) {
    System.out.print(prompt);
    while (!s.hasNextInt()) {
      System.out.println("Введіть ціле число");
      s.next();
      System.out.print(prompt);
    }
    return s.nextInt();
  }

  private static double number(Scanner s, String prompt) {
    System.out.print(prompt);
    while (!s.hasNextDouble()) {
      System.out.println("Введіть число");
      s.next();
      System.out.print(prompt);
    }
    return s.nextDouble();
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N3, завдання 1 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      fuel(s);
    }
  }
}
