package semester1.practice04;

public class Ex17 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      char choice;
      do {
        System.out.print("Два числа для додавання: ");
        double a = scanner.nextDouble(), b = scanner.nextDouble();
        System.out.println("Сума: " + (a + b));
        System.out.print("Бажаєте продовжити? (y/n): ");
        choice = scanner.next().toLowerCase().charAt(0);
      } while (choice == 'y');
    }
  }
}
