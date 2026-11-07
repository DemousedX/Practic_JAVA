package semester1.practice03;

public class Ex12 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Бал 0-100: ");
      int score = scanner.nextInt();
      String grade;
      if (score < 0 || score > 100) {
        grade = "Помилка: некоректний бал!";
      } else if (score >= 90) {
        grade = "Відмінно (A)";
      } else if (score >= 82) {
        grade = "Дуже добре (B)";
      } else if (score >= 74) {
        grade = "Добре (C)";
      } else if (score >= 64) {
        grade = "Задовільно (D)";
      } else if (score >= 60) {
        grade = "Достатньо (E)";
      } else {
        grade = "Незадовільно (F)";
      }
      System.out.println(grade);
    }
  }
}
