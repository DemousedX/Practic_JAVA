package semester1.practice03;

public class Ex40 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("PIN: ");
      int pin = scanner.nextInt();
      if (pin != 1234) {
        System.out.println("Хибний PIN");
        return;
      } else {
        System.out.println("Авторизація успішна!");
      }
      double balance = 5000;
      int choice;
      do {
        System.out.print("1 Баланс | 2 Поповнити | 3 Зняти | 4 Вихід: ");
        choice = scanner.nextInt();
        switch (choice) {
          case 1 -> System.out.printf("Баланс: %.2f грн%n", balance);
          case 2 -> {
            System.out.print("Сума: ");
            double amount = scanner.nextDouble();
            if (amount > 0) {
              balance += amount;
              System.out.printf("Баланс: %.2f грн%n", balance);
            } else {
              System.out.println("Сума має бути додатною");
            }
          }
          case 3 -> {
            System.out.print("Сума: ");
            double amount = scanner.nextDouble();
            if (amount > 0 && amount <= balance) {
              double fee = amount > 1000 ? amount * 0.01 : 0;
              if (amount + fee <= balance) {
                balance -= amount + fee;
                System.out.printf(
                    "Комісія: %.2f грн | Видано: %.2f грн | Залишок: %.2f грн%n",
                    fee, amount, balance);
              } else {
                System.out.println("Недостатньо коштів з урахуванням комісії");
              }
            } else {
              System.out.println("Недостатньо коштів або некоректна сума");
            }
          }
          case 4 -> System.out.println("Роботу завершено");
          default -> System.out.println("Невідомий пункт");
        }
      } while (choice != 4 && scanner.hasNext());
    }
  }
}
