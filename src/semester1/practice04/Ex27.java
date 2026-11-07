package semester1.practice04;

public class Ex27 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("N: ");
      int n = scanner.nextInt();
      if (n < 0) {
        System.out.println("Кількість не може бути від'ємною");
        return;
      }
      long sum = 0;
      for (long i = 1; i <= n; i++) {
        sum += i % 2 == 1 ? i : -i;
      }
      System.out.println(sum);
    }
  }
}
