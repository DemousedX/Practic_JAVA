package semester1.practice03;

public class Ex13 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Три цілі числа: ");
      int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), min = a, max = a;
      if (b < min) {
        min = b;
      }
      if (c < min) {
        min = c;
      }
      if (b > max) {
        max = b;
      }
      if (c > max) {
        max = c;
      }
      System.out.println("Максимум: " + max);
      System.out.println("Мінімум: " + min);
    }
  }
}
