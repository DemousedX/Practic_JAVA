package semester1.practice03;

public class Ex6 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Символ: ");
      char ch = scanner.next().charAt(0);
      System.out.println("Символ: " + ch + " | Код символу: " + (int) ch);
    }
  }
}
