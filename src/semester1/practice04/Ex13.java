package semester1.practice04;

public class Ex13 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      int secret = (int) (Math.random() * 100) + 1, attempts = 0, guess = 0;
      while (guess != secret) {
        System.out.print("Вгадайте число 1-100: ");
        guess = scanner.nextInt();
        attempts++;
        if (guess < secret) {
          System.out.println("Більше!");
        } else if (guess > secret) {
          System.out.println("Менше!");
        }
      }
      System.out.println("Вгадали за " + attempts + " спроб");
    }
  }
}
