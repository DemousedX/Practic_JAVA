package semester1.practice03;

public class Ex11 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Вік: ");
      int age = scanner.nextInt();
      if (age < 0 || age > 120) {
        System.out.println("Некоректний вік");
      } else if (age <= 12) {
        System.out.println("Дитина");
      } else if (age <= 17) {
        System.out.println("Підліток");
      } else if (age <= 64) {
        System.out.println("Дорослий");
      } else {
        System.out.println("Пенсіонер");
      }
    }
  }
}
