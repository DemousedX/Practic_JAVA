package semester1.practice03;

public class Ex30 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Три сторони: ");
      double a = scanner.nextDouble(), b = scanner.nextDouble(), c = scanner.nextDouble();
      boolean valid = a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
      System.out.println("Трикутник існує: " + valid);
    }
  }
}
