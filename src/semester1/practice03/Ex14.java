package semester1.practice03;

public class Ex14 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Координати x і y: ");
      double x = scanner.nextDouble(), y = scanner.nextDouble();
      if (x == 0 && y == 0) {
        System.out.println("Початок координат");
      } else if (x == 0 || y == 0) {
        System.out.println("Точка на осі координат");
      } else if (x > 0 && y > 0) {
        System.out.println("I чверть");
      } else if (x < 0 && y > 0) {
        System.out.println("II чверть");
      } else if (x < 0 && y < 0) {
        System.out.println("III чверть");
      } else {
        System.out.println("IV чверть");
      }
    }
  }
}
