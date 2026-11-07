package semester1.practice04;

public class Ex38 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Висота: ");
      int n = scanner.nextInt();
      if (n < 1) {
        System.out.println("Висота має бути додатною");
        return;
      }
      for (int i = 1; i <= n; i++) {
        for (int j = 0; j < i; j++) {
          System.out.print("*");
        }
        System.out.println();
      }
    }
  }
}
