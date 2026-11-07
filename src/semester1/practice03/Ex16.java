package semester1.practice03;

public class Ex16 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Спожито кВт*год: ");
      double k = scanner.nextDouble();
      if (k < 0) {
        System.out.println("Споживання не може бути від'ємним");
        return;
      }
      double cost = k <= 100 ? k * 2.64 : 100 * 2.64 + (k - 100) * 4.32;
      System.out.printf("До сплати: %.2f грн%n", cost);
    }
  }
}
