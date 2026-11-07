package semester1.practice03;

public class Ex22 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Сума покупки: ");
      double sum = scanner.nextDouble();
      if (sum < 0) {
        System.out.println("Некоректна сума");
        return;
      }
      double total = sum * (sum > 1000 ? 0.9 : 0.98);
      System.out.printf("До сплати: %.2f грн%n", total);
    }
  }
}
