package semester1.practice03;

public class Ex20 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Бал: ");
      int score = scanner.nextInt();
      System.out.println(score >= 60 ? "Зараховано" : "Незараховано");
    }
  }
}
