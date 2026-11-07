package semester1.practice04;

public class Ex9 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Додатне число: ");
      long n = scanner.nextLong();
      if (n <= 0) {
        System.out.println("Потрібне додатне число");
        return;
      }
      int digits = 0, sum = 0;
      while (n > 0) {
        sum += n % 10;
        n /= 10;
        digits++;
      }
      System.out.println("Цифр: " + digits + ", сума: " + sum);
    }
  }
}
