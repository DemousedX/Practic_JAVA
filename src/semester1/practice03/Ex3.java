package semester1.practice03;

public class Ex3 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Сума UAH і курс USD: ");
      double uah = scanner.nextDouble(), rate = scanner.nextDouble();
      if (uah < 0 || rate <= 0) {
        System.out.println("Некоректна сума або курс");
        return;
      }
      System.out.printf("До видачі: %.2f USD%n", uah / rate);
    }
  }
}
