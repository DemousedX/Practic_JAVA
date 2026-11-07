package semester1.practice04;

public class Ex2 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Текст: ");
      String text = scanner.nextLine();
      System.out.print("Кількість копій: ");
      int n = scanner.nextInt();
      if (n < 1) {
        System.out.println("Кількість має бути додатною");
        return;
      }
      for (int i = 1; i <= n; i++) {
        System.out.println("[" + i + "] " + text);
      }
    }
  }
}
