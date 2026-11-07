package semester1.practice03;

public class Ex19 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Ціле число: ");
      int n = scanner.nextInt();
      String result = n % 2 == 0 ? "Парне" : "Непарне";
      System.out.println(result);
    }
  }
}
