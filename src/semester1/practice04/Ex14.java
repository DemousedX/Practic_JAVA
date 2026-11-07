package semester1.practice04;

public class Ex14 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      int choice;
      do {
        System.out.println("1 Нова гра | 2 Завантажити збереження | 3 Налаштування | 0 Вихід");
        choice = scanner.nextInt();
        switch (choice) {
          case 1 -> System.out.println("Нову гру розпочато");
          case 2 -> System.out.println("Збереження завантажено");
          case 3 -> System.out.println("Налаштування відкрито");
          case 0 -> System.out.println("Вихід");
          default -> System.out.println("Невідомий пункт");
        }
      } while (choice != 0);
    }
  }
}
