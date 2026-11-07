package semester1.practice06;

public class Ex35 {
  static class ShoppingCart {
    private double[] itemPrices = new double[10];
    private int count;

    public void addItem(double price) {
      if (price >= 0 && count < itemPrices.length) itemPrices[count++] = price;
    }

    public double getTotalCost() {
      double sum = 0;
      for (int i = 0; i < count; i++) sum += itemPrices[i];
      return sum;
    }

    public void applyDiscount(double percent) {
      if (percent < 0 || percent > 100) return;
      for (int i = 0; i < count; i++) itemPrices[i] *= 1 - percent / 100;
    }

    public void printReceipt() {
      for (int i = 0; i < count; i++) System.out.printf("%d: %.2f грн%n", i + 1, itemPrices[i]);
      System.out.printf("Разом: %.2f грн%n", getTotalCost());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ShoppingCart c = new ShoppingCart();
    c.addItem(100);
    c.addItem(200);
    c.addItem(300);
    c.printReceipt();
    c.applyDiscount(15);
    c.printReceipt();
  }
}
