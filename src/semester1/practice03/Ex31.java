package semester1.practice03;

public class Ex31 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Ціле число: ");
      int n = scanner.nextInt();
      boolean isEvenBitwise = (n & 1) == 0;
      System.out.println("Через &: " + isEvenBitwise);
      System.out.println("Через %: " + (n % 2 == 0));
      System.out.println(
          "Побітове І з 1 залишає тільки останній біт, у парного числа він нульовий");
    }
  }
}
