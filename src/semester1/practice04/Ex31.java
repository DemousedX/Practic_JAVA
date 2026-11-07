package semester1.practice04;

public class Ex31 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Слово: ");
      String text = scanner.next();
      String result = "";
      for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);
        result += (char) (ch + 1);
      }
      System.out.println(result);
    }
  }
}
