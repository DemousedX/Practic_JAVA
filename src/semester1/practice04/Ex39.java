package semester1.practice04;

public class Ex39 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("N: ");
      int n = scanner.nextInt();
      for (int i = 2; i <= n; i++) {
        boolean prime = true;
        for (int j = 2; j <= i / j; j++) {
          if (i % j == 0) {
            prime = false;
            break;
          }
        }
        if (prime) {
          System.out.print(i + " ");
        }
      }
      System.out.println();
    }
  }
}
