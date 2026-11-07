package semester1.practice09;

import java.util.Arrays;

public final class Ex36 {
  private Ex36() {}

  abstract static class AbstractAsset {
    private final String ticker;
    protected double investedAmount;

    AbstractAsset(String n, double v) {
      ticker = n;
      investedAmount = Math.max(0, v);
    }

    public abstract double calculateAnnualReturn();

    public double investedAmount() {
      return investedAmount;
    }

    public String toString() {
      return ticker + "=" + investedAmount() + " грн, return=" + calculateAnnualReturn() + " грн";
    }
  }

  static final class GovernmentBond extends AbstractAsset {
    private final double coupon;

    GovernmentBond(String n, double v, double c) {
      super(n, v);
      coupon = c;
    }

    public double calculateAnnualReturn() {
      return investedAmount * coupon;
    }
  }

  static final class DividendStock extends AbstractAsset {
    private final double growth, dividend, tax;

    DividendStock(String n, double v, double g, double d, double t) {
      super(n, v);
      growth = g;
      dividend = d;
      tax = t;
    }

    public double calculateAnnualReturn() {
      return investedAmount * (growth + dividend) * (1 - tax);
    }
  }

  static final class InvestmentPortfolio {
    private final String investorName;
    private final AbstractAsset[] assets;
    private int count;

    InvestmentPortfolio(String n, int cap) {
      investorName = n;
      assets = new AbstractAsset[cap];
    }

    public void add(AbstractAsset a) {
      if (a != null && count < assets.length) assets[count++] = a;
    }

    public double totalValue() {
      double x = 0;
      for (int i = 0; i < count; i++) x += assets[i].investedAmount();
      return x;
    }

    public double expectedReturn() {
      double x = 0;
      for (int i = 0; i < count; i++) x += assets[i].calculateAnnualReturn();
      return x;
    }

    public String toString() {
      return investorName
          + " "
          + Arrays.toString(Arrays.copyOf(assets, count))
          + String.format(" | total=%.2f, annual=%.2f", totalValue(), expectedReturn());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    var p = new InvestmentPortfolio("Олена", 5);
    p.add(new GovernmentBond("ОВДП", 10000, .155));
    p.add(new DividendStock("Tech", 8000, .06, .02, .19));
    System.out.println(p);
  }
}
