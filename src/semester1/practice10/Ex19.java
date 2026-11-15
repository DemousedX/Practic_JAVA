package semester1.practice10;

public class Ex19 {

  abstract static class AbstractFinancialInstrument {
    private final String ticker;
    protected int quantity;

    AbstractFinancialInstrument(String ticker, int quantity) {
      this.ticker = ticker;
      this.quantity = quantity;
    }

    public abstract double getMarketValueUah();

    public String getTicker() {
      return ticker;
    }
  }

  interface Tradable {
    boolean buy(int qty);

    boolean sell(int qty);
  }

  interface DividendPaying {
    double calculateAnnualDividend();
  }

  static class TechGrowthStock extends AbstractFinancialInstrument implements Tradable {
    protected final double price;

    TechGrowthStock(String ticker, int quantity, double price) {
      super(ticker, quantity);
      this.price = price;
    }

    @Override
    public double getMarketValueUah() {
      return quantity * price;
    }

    @Override
    public boolean buy(int qty) {
      if (qty <= 0) return false;
      quantity += qty;
      return true;
    }

    @Override
    public boolean sell(int qty) {
      if (qty <= 0 || qty > quantity) return false;
      quantity -= qty;
      return true;
    }
  }

  static class BlueChipStock extends AbstractFinancialInstrument
      implements Tradable, DividendPaying {
    private final double price, dividendPerShare;

    BlueChipStock(String ticker, int quantity, double price, double dividendPerShare) {
      super(ticker, quantity);
      this.price = price;
      this.dividendPerShare = dividendPerShare;
    }

    @Override
    public double getMarketValueUah() {
      return quantity * price;
    }

    @Override
    public boolean buy(int qty) {
      if (qty <= 0) return false;
      quantity += qty;
      return true;
    }

    @Override
    public boolean sell(int qty) {
      if (qty <= 0 || qty > quantity) return false;
      quantity -= qty;
      return true;
    }

    @Override
    public double calculateAnnualDividend() {
      return quantity * dividendPerShare;
    }
  }

  static class FixedTermDeposit extends AbstractFinancialInstrument implements DividendPaying {
    private final double principal, rate;

    FixedTermDeposit(double principal, double rate) {
      super("DEPOSIT", 1);
      this.principal = principal;
      this.rate = rate;
    }

    @Override
    public double getMarketValueUah() {
      return principal;
    }

    @Override
    public double calculateAnnualDividend() {
      return principal * rate;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    AbstractFinancialInstrument[] portfolio = {
      new TechGrowthStock("TECH", 10, 500),
      new BlueChipStock("BLUE", 20, 300, 15),
      new FixedTermDeposit(10000, 0.1)
    };
    for (AbstractFinancialInstrument f : portfolio) {
      if (f instanceof Tradable t) {
        t.buy(2);
        t.sell(1);
      }
      System.out.println(f.getTicker() + ": " + f.getMarketValueUah());
      if (f instanceof DividendPaying d)
        System.out.println("Річний дохід: " + d.calculateAnnualDividend());
    }
  }
}
