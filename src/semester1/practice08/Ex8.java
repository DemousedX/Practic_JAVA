package semester1.practice08;

public class Ex8 {
  static class InvoiceItem {
    private String description;
    private int quantity;
    private double unitPrice, discountPercent;

    public InvoiceItem(String description, int quantity, double unitPrice, double discountPercent) {
      this.description = description;
      this.quantity = Math.max(0, quantity);
      this.unitPrice = Math.max(0, unitPrice);
      this.discountPercent = Math.max(0, Math.min(50, discountPercent));
    }

    public double getFinalAmount() {
      return quantity * unitPrice * (1 - discountPercent / 100);
    }

    public String toString() {
      return String.format(
          "%s x %d | %.2f грн | знижка %.1f%% | разом %.2f грн",
          description, quantity, unitPrice, discountPercent, getFinalAmount());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    InvoiceItem item = new InvoiceItem("Папір", 3, 125.5, 10);
    System.out.println("Позиція чека: " + item);
  }
}
