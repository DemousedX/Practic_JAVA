package semester1.practice04;

public class Ex19 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Чисельник: ");
      double a = scanner.nextDouble(), b;
      do {
        System.out.print("Знаменник, не 0: ");
        b = scanner.nextDouble();
      } while (b == 0);
      System.out.println(a / b);
    }
  }
}
