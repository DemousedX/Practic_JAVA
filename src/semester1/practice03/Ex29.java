package semester1.practice03;

public class Ex29 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Години і хвилини: ");
      int hours = scanner.nextInt(), minutes = scanner.nextInt();
      boolean isValidTime = (hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59);
      if (isValidTime) {
        System.out.printf("%02d:%02d%n", hours, minutes);
      } else {
        System.out.println("Некоректний час");
      }
    }
  }
}
