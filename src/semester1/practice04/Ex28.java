package semester1.practice04;

public class Ex28 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Перший член, різниця і кількість: ");
      double a = scanner.nextDouble(), d = scanner.nextDouble();
      int n = scanner.nextInt();
      if (n < 1) {
        System.out.println("Кількість має бути додатною");
        return;
      }
      double sum = 0;
      for (int i = 0; i < n; i++) {
        double term = a + i * d;
        sum += term;
        System.out.print(term + " ");
      }
      System.out.println("\nСума: " + sum);
    }
  }
}
