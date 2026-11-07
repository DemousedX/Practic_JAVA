package semester1.practice04;

public class Ex30 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Кількість чисел: ");
      int n = scanner.nextInt();
      if (n <= 0) {
        System.out.println("Кількість має бути додатною");
        return;
      }
      int sum = 0;
      System.out.println("Введіть числа");
      for (int i = 0; i < n; i++) {
        sum = Math.addExact(sum, scanner.nextInt());
      }
      System.out.println("Сума: " + sum);
      System.out.println("З приведенням: " + (double) sum / n);
      System.out.println("Без приведення: " + sum / n);
    }
  }
}
