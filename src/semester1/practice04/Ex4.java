package semester1.practice04;

public class Ex4 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Курс EUR до UAH: ");
      double rate = scanner.nextDouble();
      if (rate <= 0) {
        System.out.println("Курс має бути додатним");
        return;
      }
      for (int eur = 10; eur <= 100; eur += 10) {
        System.out.printf("%3d EUR = %.2f UAH%n", eur, eur * rate);
      }
    }
  }
}
