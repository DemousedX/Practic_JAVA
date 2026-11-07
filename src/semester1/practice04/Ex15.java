package semester1.practice04;

public class Ex15 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      int age;
      do {
        System.out.print("Вік 1-120: ");
        age = scanner.nextInt();
      } while (age < 1 || age > 120);
      System.out.println("Вік підтверджено: " + age);
    }
  }
}
