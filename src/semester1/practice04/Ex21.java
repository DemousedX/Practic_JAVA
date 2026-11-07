package semester1.practice04;

public class Ex21 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("A і B: ");
      int a = scanner.nextInt(), b = scanner.nextInt();
      if (a > b) {
        System.out.println("A має бути не більшим за B");
        return;
      }
      for (long i = a; i <= b; i++) {
        if (i % 2 == 0) {
          System.out.print(i + " ");
        }
      }
      System.out.println();
    }
  }
}
