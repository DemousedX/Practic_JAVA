package semester1.practice10;

public class Ex36 {

  interface PrintableDocument {
    String formatForPrinter();
  }

  public static final class FiscalReceipt implements PrintableDocument {
    private final String fiscalNumber;
    private final double totalAmount, vatAmount;

    FiscalReceipt(String number, double totalAmount) {
      if (totalAmount < 0) throw new IllegalArgumentException("Сума не може бути від'ємною");
      fiscalNumber = number;
      this.totalAmount = totalAmount;
      vatAmount = totalAmount * 20 / 120;
    }

    @Override
    public String formatForPrinter() {
      return String.format(
          "Чек %s | Всього з ПДВ: %.2f | ПДВ 20%%: %.2f", fiscalNumber, totalAmount, vatAmount);
    }
  }

  static class WarehouseReport implements PrintableDocument {
    @Override
    public String formatForPrinter() {
      return "Складський звіт: 25 одиниць товару";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    for (PrintableDocument d :
        new PrintableDocument[] {new FiscalReceipt("F-001", 1200), new WarehouseReport()})
      System.out.println(d.formatForPrinter());
  }
}
