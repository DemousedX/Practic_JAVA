package semester1.practice03.homework;

import java.util.Scanner;

public final class Ex5 {
  private Ex5() {}

  private static void quest(Scanner s) {
    System.out.println("=== ВТЕЧА З ТЕМНИЦІ ЧАКЛУНА ===");
    System.out.print("Ім'я героя: ");
    String name = s.nextLine();
    int type = integer(s, "Клас (1 воїн, 2 маг, 3 розбійник): ");
    String hero =
        switch (type) {
          case 1 -> "Воїн";
          case 2 -> "Маг";
          case 3 -> "Розбійник";
          default -> "Мандрівник";
        };
    int hp = type == 1 ? 110 : type == 2 ? 75 : 90,
        mana = type == 2 ? 50 : 20,
        agility = type == 3 ? 17 : 10;
    System.out.printf("%s %s (HP %d, MP %d, AGI %d)%n", hero, name, hp, mana, agility);
    s.nextLine();
    System.out.print("Шлях (північ/схід/захід): ");
    String way = s.nextLine().trim();
    int artifacts = 0;
    if (way.equalsIgnoreCase("схід")) {
      System.out.println("Знайдено арсенал. Магія чи сила? (магія/сила)");
      String choice = s.nextLine().trim();
      if (choice.equalsIgnoreCase("магія") && mana >= 25
          || choice.equalsIgnoreCase("сила") && type == 1) {
        artifacts++;
        hp = Math.min(120, hp + 20);
        System.out.println("Скриня відчинилась, знайдено Амулет Світла (+20 HP)");
      } else {
        hp -= 20;
        System.out.println("Пастка завдала 20 шкоди");
      }
    } else if (way.equalsIgnoreCase("північ") && agility >= 12) {
      artifacts++;
      System.out.println("Спритність допомогла оминути пастку й здобути ключ");
    } else {
      hp -= 25;
      System.out.println("Варта влаштувала засідку: -25 HP");
    }
    boolean victory = hp > 0 && (artifacts > 0 || type == 1);
    System.out.println(victory ? "Ворота відчинені - перемога!" : "Темниця перемогла цього разу");
    System.out.printf(
        "Фінал %s: HP %d, артефакти %d, ранг %s%n",
        name, Math.max(0, hp), artifacts, victory ? "S" : "D");
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

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N3, завдання 5 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      quest(s);
    }
  }
}
