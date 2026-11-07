package semester1.practice04;

public class Ex40 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Розмір дошки: ");
      int n = scanner.nextInt();
      if (n < 1) {
        System.out.println("Розмір має бути додатним");
        return;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print((i + j) % 2 == 0 ? "# " : "_ ");
        }
        System.out.println();
      }
    }
  }
}
