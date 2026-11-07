package semester1.practice03;

public class Ex5 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Зріст у метрах і вага у кг: ");
      double height = scanner.nextDouble(), weight = scanner.nextDouble();
      if (height <= 0 || weight <= 0) {
        System.out.println("Значення мають бути додатними");
        return;
      }
      System.out.printf("BMI: %.2f%n", weight / (height * height));
    }
  }
}
