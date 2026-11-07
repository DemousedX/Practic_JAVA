package semester1.practice04;

public class Ex7 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.println("Вводьте цілі числа, 0 завершує");
      long sum = 0;
      int number = scanner.nextInt();
      while (number != 0) {
        sum += number;
        number = scanner.nextInt();
      }
      System.out.println("Сума: " + sum);
    }
  }
}
