package semester1.practice04;

public class Ex12 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("N > 1: ");
      long n = scanner.nextLong();
      if (n <= 1) {
        System.out.println("Потрібне число більше 1");
        return;
      }
      long divisor = 2;
      while (divisor <= n / divisor && n % divisor != 0) {
        divisor++;
      }
      System.out.println("Найменший дільник: " + (n % divisor == 0 ? divisor : n));
    }
  }
}
