package semester1.practice04;

public class Ex8 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("M: ");
      long m = scanner.nextLong(), power = 1;
      while (power <= m) {
        System.out.println(power);
        if (power > Long.MAX_VALUE / 2) {
          break;
        }
        power *= 2;
      }
    }
  }
}
