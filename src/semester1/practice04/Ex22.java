package semester1.practice04;

public class Ex22 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("N 0-20: ");
      int n = scanner.nextInt();
      if (n < 0 || n > 20) {
        System.out.println("Число поза діапазоном");
        return;
      }
      long result = 1;
      for (int i = 2; i <= n; i++) {
        result *= i;
      }
      System.out.println(result);
    }
  }
}
