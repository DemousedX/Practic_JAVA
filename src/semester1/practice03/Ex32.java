package semester1.practice03;

public class Ex32 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print(
          "PIN правильний, картка активна, вистачає коштів, ліміт перевищено (true/false): ");
      boolean isPinCorrect = scanner.nextBoolean(),
          isCardActive = scanner.nextBoolean(),
          hasSufficientBalance = scanner.nextBoolean(),
          isDailyLimitExceeded = scanner.nextBoolean();
      boolean allowed =
          isPinCorrect && isCardActive && hasSufficientBalance && !isDailyLimitExceeded;
      System.out.println("Операцію дозволено: " + allowed);
    }
  }
}
