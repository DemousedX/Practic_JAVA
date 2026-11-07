package semester1.practice09;

public class Ex18 {
  static class OrderItem {
    private final String productName;
    private final double unitPrice;
    private int quantity;

    public OrderItem(String productName, double unitPrice, int quantity) {
      this.productName = productName;
      this.unitPrice = unitPrice;
      this.quantity = quantity;
    }

    public double getItemTotal() {
      return unitPrice * quantity;
    }

    public String toString() {
      return productName + " | " + quantity + " x " + unitPrice + " = " + getItemTotal();
    }
  }

  static class ShoppingOrder {
    private final OrderItem[] items;
    private int itemCount;

    public ShoppingOrder(int capacity) {
      items = new OrderItem[capacity];
    }

    public void addItem(String name, double price, int qty) {
      if (name == null || price < 0 || qty <= 0) return;
      for (int i = 0; i < itemCount; i++)
        if (items[i].productName.equals(name)) {
          items[i].quantity += qty;
          return;
        }
      if (itemCount < items.length) items[itemCount++] = new OrderItem(name, price, qty);
    }

    public double calculateGrandTotal() {
      double sum = 0;
      for (int i = 0; i < itemCount; i++) sum += items[i].getItemTotal();
      return sum;
    }

    public String toString() {
      StringBuilder s = new StringBuilder("ЧЕК\n");
      for (int i = 0; i < itemCount; i++) s.append(items[i]).append('\n');
      return s.append("Разом: ").append(calculateGrandTotal()).toString();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ShoppingOrder o = new ShoppingOrder(10);
    o.addItem("Зошит", 85, 2);
    o.addItem("Ручка", 18, 5);
    o.addItem("Зошит", 85, 1);
    System.out.println(o);
  }
}
