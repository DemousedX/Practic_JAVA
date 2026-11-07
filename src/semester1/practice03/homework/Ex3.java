package semester1.practice03.homework;

import java.util.Scanner;

public final class Ex3 {
  private Ex3() {}

  private static void credit(Scanner s) {
    int age = integer(s, "Вік: ");
    double income = number(s, "Місячний дохід: ");
    System.out.print("Негативна кредитна історія (true/false): ");
    boolean bad = s.nextBoolean();
    double amount = number(s, "Сума кредиту: ");
    int months = integer(s, "Термін (місяців): ");
    boolean ageOk = age >= 21 && age <= 65, historyOk = !bad;
    boolean affordable = months > 0 && ((amount / months) <= income * .5);
    double rate = income >= 35000 ? 14.5 : 21;
    String reason =
        ageOk
            ? historyOk
                ? affordable
                    ? "СХВАЛЕНО"
                    : "Відмова: термін кредиту некоректний або платіж перевищує 50% доходу"
                : "Відмова: виявлено негативну кредитну історію"
            : "Відмова: вік не відповідає критеріям (21-65 років)";
    System.out.println("Рішення: " + reason);
    if (ageOk && historyOk && affordable)
      System.out.printf(
          "Платіж/міс: %.2f грн, ставка: %.1f%%, максимум: %.2f грн%n",
          amount / months, rate, income * .5);
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
    System.out.printf("%n--- ДЗ до практичної N3, завдання 3 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      credit(s);
    }
  }
}
