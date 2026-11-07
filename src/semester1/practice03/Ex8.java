package semester1.practice03;

public class Ex8 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Товар: ");
      String name = scanner.nextLine();
      System.out.print("Ціна і кількість: ");
      double price = scanner.nextDouble();
      int quantity = scanner.nextInt();
      if (price < 0 || quantity < 0) {
        System.out.println("Некоректна ціна або кількість");
        return;
      }
      double total = price * quantity;
      System.out.printf(
          "%s | Загальна сума: %.2f грн | ПДВ 20%%: %.2f грн%n", name, total, total * 0.2);
    }
  }
}
