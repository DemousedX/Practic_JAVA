package semester1.practice08;

public final class Ex2 {
  private Ex2() {}

  static class Product {
    private String sku, title;
    private double price;
    private int stock;

    Product(String sku, String title, double price, int stock) {
      this.sku = sku;
      this.title = title;
      setPrice(price);
      setStock(stock);
    }

    public void setPrice(double value) {
      price = Math.max(0, value);
    }

    public void setStock(int value) {
      stock = Math.max(0, value);
    }

    public double getTotalCost() {
      return price * stock;
    }

    @Override
    public String toString() {
      return String.format(
          "[SKU: %s] %s | Ціна: %.2f грн | Залишок: %d шт. | Разом: %.2f грн",
          sku, title, price, stock, getTotalCost());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 02 ---%n");

    System.out.println(new Product("A-101", "Монітор", 6499.5, 4));
    System.out.println(new Product("B-205", "Клавіатура", 1599, 7));
  }
}
