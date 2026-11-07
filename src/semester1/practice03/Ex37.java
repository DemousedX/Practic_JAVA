package semester1.practice03;

public class Ex37 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Доставка (1 самовивіз, 2 кур'єр, 3 поштомат) і вага: ");
      int method = scanner.nextInt();
      double weight = scanner.nextDouble();
      if (weight <= 0) {
        System.out.println("Вага має бути додатною");
        return;
      }
      double price =
          switch (method) {
            case 1 -> 0;
            case 2 -> {
              double cost = weight > 5 ? 150 : 90;
              yield cost;
            }
            case 3 -> 60;
            default -> -1;
          };
      System.out.println(price < 0 ? "Невідомий спосіб доставки" : "Вартість: " + price + " грн");
    }
  }
}
