package semester1.practice03;

public class Ex34 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("День 1-7: ");
      int day = scanner.nextInt();
      switch (day) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
          System.out.println("Будній (робочий) день");
          break;
        case 6:
        case 7:
          System.out.println("Вихідний день");
          break;
        default:
          System.out.println("Некоректний номер дня");
      }
    }
  }
}
