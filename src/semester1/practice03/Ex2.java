package semester1.practice03;

public class Ex2 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Два цілі числа: ");
      int a = scanner.nextInt(), b = scanner.nextInt();
      System.out.println("Сума: " + ((long) a + b));
      System.out.println("Різниця: " + ((long) a - b));
      System.out.println("Добуток: " + ((long) a * b));
      System.out.println(b == 0 ? "Ділення на нуль неможливе" : "Остача: " + a % b);
    }
  }
}
