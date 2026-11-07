package semester1.practice04;

public class Ex11 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Початкова сума і річний відсоток: ");
      double initial = scanner.nextDouble(), rate = scanner.nextDouble();
      if (initial <= 0 || rate <= 0) {
        System.out.println("Сума і відсоток мають бути додатними");
        return;
      }
      double amount = initial;
      int years = 0;
      while (amount < 2 * initial) {
        double next = amount * (1 + rate / 100);
        if (next == amount) {
          System.out.println("Ставка надто мала для розрахунку");
          return;
        }
        amount = next;
        years++;
      }
      System.out.println("Років: " + years);
    }
  }
}
