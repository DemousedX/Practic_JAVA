package semester1.practice04;

public class Ex10 {
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
      java.math.BigInteger reverse = java.math.BigInteger.ZERO;
      while (n > 0) {
        reverse =
            reverse.multiply(java.math.BigInteger.TEN).add(java.math.BigInteger.valueOf(n % 10));
        n /= 10;
      }
      System.out.println(reverse);
    }
  }
}
