package semester1.practice04;

public class Ex16 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      int attempts = 0, pin;
      do {
        System.out.print("PIN: ");
        pin = scanner.nextInt();
        attempts++;
        if (pin == 1234) {
          System.out.println("Доступ надано");
          break;
        }
      } while (attempts < 3);
      if (pin != 1234) {
        System.out.println("Карту заблоковано!");
      }
    }
  }
}
