package semester1.practice03;

public class Ex18 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Ціле число: ");
      int n = scanner.nextInt();
      long abs = n < 0 ? -(long) n : n;
      System.out.println(abs);
    }
  }
}
