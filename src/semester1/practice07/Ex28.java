package semester1.practice07;

public class Ex28 {
  static class CurrencyExchange {
    private static double usdToUahRate = 41.5, eurToUahRate = 45.2;

    public static void updateRates(double newUsd, double newEur) {
      if (newUsd > 0 && newEur > 0) {
        usdToUahRate = newUsd;
        eurToUahRate = newEur;
      }
    }

    public static double uahToUsd(double uah) {
      return uah / usdToUahRate;
    }

    public static double usdToUah(double usd) {
      return usd * usdToUahRate;
    }

    public static double eurToUah(double eur) {
      return eur * eurToUahRate;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(CurrencyExchange.uahToUsd(4150));
    System.out.println(CurrencyExchange.usdToUah(100));
    System.out.println(CurrencyExchange.eurToUah(100));
    CurrencyExchange.updateRates(42, 46);
    System.out.println(CurrencyExchange.usdToUah(100));
  }
}
