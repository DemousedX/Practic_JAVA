package semester1.practice03;

public class Ex7 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Два катети: ");
      double a = scanner.nextDouble(), b = scanner.nextDouble();
      if (a <= 0 || b <= 0) {
        System.out.println("Катети мають бути додатними");
        return;
      }
      double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
      System.out.println("Гіпотенуза: " + c);
      System.out.println("Периметр: " + (a + b + c));
      System.out.println("Площа: " + a * b / 2);
    }
  }
}
