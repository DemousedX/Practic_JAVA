package semester1.practice03;

public class Ex35 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Місяць 1-12: ");
      int month = scanner.nextInt();
      int days =
          switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
          };
      System.out.println(days == 0 ? "Неіснуючий місяць" : "Днів: " + days);
    }
  }
}
