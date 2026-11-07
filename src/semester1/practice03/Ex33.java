package semester1.practice03;

public class Ex33 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("День 1-7: ");
      int day = scanner.nextInt();
      switch (day) {
        case 1:
          System.out.println("Понеділок");
          break;
        case 2:
          System.out.println("Вівторок");
          break;
        case 3:
          System.out.println("Середа");
          break;
        case 4:
          System.out.println("Четвер");
          break;
        case 5:
          System.out.println("П'ятниця");
          break;
        case 6:
          System.out.println("Субота");
          break;
        case 7:
          System.out.println("Неділя");
          break;
        default:
          System.out.println("Некоректний номер дня");
      }
    }
  }
}
