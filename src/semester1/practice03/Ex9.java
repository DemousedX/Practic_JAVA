package semester1.practice03;

public class Ex9 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Число: ");
      double n = scanner.nextDouble();
      if (n > 0) {
        System.out.println("Додатне");
      } else if (n < 0) {
        System.out.println("Від'ємне");
      } else {
        System.out.println("Нуль");
      }
    }
  }
}
