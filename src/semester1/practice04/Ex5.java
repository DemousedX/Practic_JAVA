package semester1.practice04;

public class Ex5 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Ширина: ");
      int width = scanner.nextInt();
      if (width < 1) {
        System.out.println("Ширина має бути додатною");
        return;
      }
      for (int i = 0; i < width; i++) {
        System.out.print("=");
      }
      System.out.println();
    }
  }
}
