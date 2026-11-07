package semester1.practice03;

public class Ex21 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Число: ");
      double n = scanner.nextDouble();
      String status = n > 0 ? "Додатне" : n < 0 ? "Від'ємне" : "Нуль";
      System.out.println(status);
    }
  }
}
