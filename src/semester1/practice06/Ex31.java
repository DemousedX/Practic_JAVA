package semester1.practice06;

public class Ex31 {
  static class DiscountCard {
    private String ownerName = "Іван";
    private double totalSpent;
    private int discountPercent = 1;

    public void addPurchase(double cost) {
      if (cost <= 0) return;
      totalSpent += cost;
      discountPercent = totalSpent >= 10000 ? 10 : totalSpent >= 5000 ? 5 : 1;
    }

    public void printCardInfo() {
      System.out.println(
          ownerName + " | покупки " + totalSpent + " | знижка " + discountPercent + "%");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    DiscountCard c = new DiscountCard();
    c.addPurchase(3000);
    c.printCardInfo();
    c.addPurchase(4000);
    c.printCardInfo();
    c.addPurchase(3000);
    c.printCardInfo();
  }
}
