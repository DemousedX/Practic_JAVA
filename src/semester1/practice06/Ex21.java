package semester1.practice06;

public class Ex21 {
  static class CurrencyExchange {
    double usdRate = 41.5;

    public double toUSD(double uah) {
      return uah / usdRate;
    }

    public double toUAH(double usd) {
      return usd * usdRate;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    CurrencyExchange c = new CurrencyExchange();
    System.out.printf("%.2f USD%n", c.toUSD(10000));
    System.out.printf("%.2f UAH%n", c.toUAH(100));
  }
}
