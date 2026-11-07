package semester1.practice08;

import java.util.Arrays;

public final class Ex36 {
  private Ex36() {}

  static class WarehouseItem {
    protected String name;
    protected int quantity;
    private double[] priceHistory;

    WarehouseItem(String name, int quantity, double[] history) {
      this.name = name;
      this.quantity = Math.max(0, quantity);
      priceHistory = history.clone();
    }

    public double getAveragePurchasePrice() {
      return Arrays.stream(priceHistory).average().orElse(0);
    }

    public double inventoryValue() {
      return quantity * getAveragePurchasePrice();
    }

    @Override
    public String toString() {
      return name + ", qty=" + quantity + ", average purchase price=" + getAveragePurchasePrice();
    }
  }

  static class DiscountedWarehouseItem extends WarehouseItem {
    private String markdownReason;
    private double discountPercent;

    DiscountedWarehouseItem(
        String name, int quantity, double[] history, String reason, double discount) {
      super(name, quantity, history);
      markdownReason = reason;
      discountPercent = Math.max(0, Math.min(100, discount));
    }

    public double saleValue() {
      return inventoryValue() * (1 - discountPercent / 100);
    }

    @Override
    public String toString() {
      return super.toString()
          + ", discount="
          + discountPercent
          + "%, reason="
          + markdownReason
          + ", sale value="
          + String.format("%.2f", saleValue());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 36 ---%n");

    System.out.println(
        new DiscountedWarehouseItem(
            "SSD 1TB", 5, new double[] {3200, 3400, 3100}, "New model", 15));
  }
}
