package semester1.practice03;

public class Ex24 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Кількість помилок: ");
      int count = scanner.nextInt();
      if (count < 0) {
        System.out.println("Кількість не може бути від'ємною");
        return;
      }
      System.out.println(count == 1 ? "Знайдено 1 помилку" : "Знайдено " + count + " помилок");
    }
  }
}
