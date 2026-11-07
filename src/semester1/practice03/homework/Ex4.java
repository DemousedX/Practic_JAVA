package semester1.practice03.homework;

import java.util.Scanner;

public final class Ex4 {
  private Ex4() {}

  private static void climate(Scanner s) {
    double current = number(s, "Поточна температура: "),
        desired = number(s, "Бажана температура: ");
    int humidity = integer(s, "Вологість (%%): ");
    s.nextLine();
    System.out.print("Сезон (зима/літо/міжсезоння): ");
    String season = s.nextLine().trim().toLowerCase();
    int mode = integer(s, "Режим (1 normal, 2 eco, 3 vacation): ");
    s.nextLine();
    System.out.print("Вікно відчинене (так/ні): ");
    boolean window = s.nextLine().trim().equalsIgnoreCase("так");
    double target =
        switch (mode) {
          case 1 -> desired;
          case 2 -> {
            double eco = desired;
            if (season.equals("зима")) eco = Math.min(eco, 20);
            else if (season.equals("літо")) eco = Math.max(eco, 24);
            yield eco;
          }
          case 3 -> season.equals("зима") ? 16 : 28;
          default -> desired;
        };
    boolean active = !window && mode != 3;
    String action =
        window
            ? "Систему заблоковано: відчинене вікно"
            : !active
                ? "Режим відсутності: клімат-контроль економить енергію"
                : current < target - 0.5
                    ? "Опалення УВІМКНЕНО"
                    : current > target + 0.5 ? "Охолодження УВІМКНЕНО" : "Температура комфортна";
    String humidifier =
        humidity < 35
            ? "Зволожувач УВІМКНЕНО"
            : humidity > 65 ? "Осушувач УВІМКНЕНО" : "Вологість нормальна";
    System.out.printf(
        "Ціль: %.2f deg C%n%s%n%s%n",
        target, action, window ? "Зволожувач також вимкнено" : humidifier);
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
    System.out.printf("%n--- ДЗ до практичної N3, завдання 4 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      climate(s);
    }
  }
}
