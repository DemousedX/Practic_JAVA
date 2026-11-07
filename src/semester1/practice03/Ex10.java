package semester1.practice03;

public class Ex10 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Ціле число: ");
      int n = scanner.nextInt();
      if (n == 0) {
        System.out.println("Число є нулем");
      } else if (n % 2 == 0) {
        System.out.println("Парне");
      } else {
        System.out.println("Непарне");
      }
    }
  }
}
