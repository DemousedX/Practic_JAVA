package semester1.practice03;

public class Ex38 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Перше число: ");
      double a = scanner.nextDouble();
      System.out.print("Операція: ");
      char op = scanner.next().charAt(0);
      System.out.print("Друге число: ");
      double b = scanner.nextDouble();
      if (op == '/' && b == 0) {
        System.out.println("Ділення на нуль неможливе");
        return;
      }
      double result =
          switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> Double.NaN;
          };
      System.out.println(Double.isNaN(result) ? "Невідома операція" : "Результат: " + result);
    }
  }
}
