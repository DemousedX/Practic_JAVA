package semester1.practice07;

public class Ex14 {
  static class CoffeeOrder {
    String type, size;
    int sugarCount;
    boolean withSyrup;
    double finalPrice;

    private double calculatePrice() {
      double base =
          switch (type) {
            case "Еспресо" -> 40;
            case "Капучино" -> 55;
            case "Лате" -> 60;
            default -> throw new IllegalArgumentException("Невідомий тип кави");
          };
      double factor =
          switch (size) {
            case "Small" -> 1;
            case "Medium" -> 1.3;
            case "Large" -> 1.6;
            default -> throw new IllegalArgumentException("Невідомий розмір");
          };
      return base * factor + (withSyrup ? 15 : 0);
    }

    public CoffeeOrder(String type, String size, int sugarCount, boolean withSyrup) {
      this.type = type;
      this.size = size;
      this.sugarCount = sugarCount;
      this.withSyrup = withSyrup;
      finalPrice = calculatePrice();
    }

    public CoffeeOrder(String type, String size) {
      this(type, size, 0, false);
    }

    public CoffeeOrder(String type) {
      this(type, "Medium");
    }

    public void printReceipt() {
      System.out.printf(
          "%s | %s | цукор %d | сироп %s | %.2f грн%n",
          type, size, sugarCount, withSyrup, finalPrice);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new CoffeeOrder("Еспресо").printReceipt();
    new CoffeeOrder("Капучино", "Small").printReceipt();
    new CoffeeOrder("Лате", "Large", 2, true).printReceipt();
  }
}
