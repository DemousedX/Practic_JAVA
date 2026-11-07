package semester1.practice03;

public class Ex23 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Ділене і дільник: ");
      int a = scanner.nextInt(), b = scanner.nextInt();
      System.out.println(
          b != 0 ? "Результат: " + (double) a / b : "Помилка: ділення на нуль неможливе!");
    }
  }
}
