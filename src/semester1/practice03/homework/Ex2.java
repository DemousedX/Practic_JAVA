package semester1.practice03.homework;

import java.util.Scanner;

public final class Ex2 {
  private Ex2() {}

  private static void delivery(Scanner s) {
    double weight = number(s, "Вага (кг): ");
    int distance = integer(s, "Відстань (км): "),
        type = integer(s, "Доставка (1 відділення, 2 поштомат, 3 кур'єр): ");
    s.nextLine();
    System.out.print("Premium? (так/ні): ");
    String premium = s.nextLine();
    if (weight <= 0 || weight > 50 || distance <= 0) {
      System.out.println("Некоректні вага або відстань");
      return;
    }
    double base =
        switch (type) {
          case 1 -> 50;
          case 2 -> weight > 15 ? -1 : 60;
          case 3 -> 100;
          default -> -1;
        };
    if (base < 0) {
      System.out.println(
          type == 2 ? "Поштомат не приймає посилки понад 15 кг" : "Невідомий тип доставки");
      return;
    }
    double distanceFee = distance <= 50 ? 0 : distance <= 200 ? 35 : 80,
        total = base + distanceFee,
        finalCost = premium.equalsIgnoreCase("так") ? total * .8 : total;
    System.out.printf(
        "Базовий тариф: %.2f грн%nДоплата за відстань: %.2f грн%nPremium: %s%nДо сплати: %.2f"
            + " грн%n",
        base, distanceFee, premium.equalsIgnoreCase("так") ? "-20%" : "ні", finalCost);
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
    System.out.printf("%n--- ДЗ до практичної N3, завдання 2 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      delivery(s);
    }
  }
}
