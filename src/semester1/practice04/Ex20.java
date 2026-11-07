package semester1.practice04;

public class Ex20 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      int score, count = 0;
      long sum = 0;
      do {
        System.out.print("Бал 0-100, від'ємний для завершення: ");
        score = scanner.nextInt();
        if (score >= 0 && score <= 100) {
          sum += score;
          count++;
        } else if (score > 100) {
          System.out.println("Некоректний бал");
        }
      } while (score >= 0);
      System.out.println(count == 0 ? "Оцінок немає" : "Середній бал: " + (double) sum / count);
    }
  }
}
