package semester1.practice07;

public class Ex5 {
  static class Product {
    private String name, category;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity, String category) {
      this.name = name;
      this.price = Math.max(0, price);
      this.quantity = Math.max(0, quantity);
      this.category = category;
    }

    public double getTotalValue() {
      return price * quantity;
    }

    public void applyDiscount(double percent) {
      if (percent >= 0 && percent <= 100) price *= 1 - percent / 100;
    }

    public void printProduct() {
      System.out.printf(
          "%s | %s | %d x %.2f = %.2f грн%n", name, category, quantity, price, getTotalValue());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Product p = new Product("Зошит", 50, 10, "Канцелярія");
    p.printProduct();
    p.applyDiscount(20);
    p.printProduct();
  }
}
