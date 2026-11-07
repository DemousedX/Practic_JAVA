package semester1.practice03;

public class Ex17 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Два цілі числа: ");
      int x = scanner.nextInt(), y = scanner.nextInt();
      int max = x > y ? x : y;
      System.out.println(max);
    }
  }
}
