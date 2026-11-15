package semester1.practice10;

public class Ex1 {

  abstract static class PaymentInstrument {
    private final String payerName;

    PaymentInstrument(String payerName) {
      this.payerName = payerName;
    }

    public abstract double calculateFee(double amount);

    public double processPayment(double amount) {
      return amount + calculateFee(amount);
    }

    public String getPayerName() {
      return payerName;
    }
  }

  static class BankCardInstrument extends PaymentInstrument {
    BankCardInstrument(String name) {
      super(name);
    }

    @Override
    public double calculateFee(double amount) {
      return amount * 0.015 + 5;
    }
  }

  static class CryptoTokenInstrument extends PaymentInstrument {
    private final double gasFeeUah;

    CryptoTokenInstrument(String name, double gasFeeUah) {
      super(name);
      this.gasFeeUah = gasFeeUah;
    }

    @Override
    public double calculateFee(double amount) {
      return gasFeeUah;
    }
  }

  static class IbanDirectInstrument extends PaymentInstrument {
    IbanDirectInstrument(String name) {
      super(name);
    }

    @Override
    public double calculateFee(double amount) {
      return amount <= 50000 ? 0 : amount * 0.005;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    PaymentInstrument[] payments = {
      new BankCardInstrument("Олександр"),
      new CryptoTokenInstrument("Олександр", 40),
      new IbanDirectInstrument("Олександр")
    };
    double total = 0;
    for (PaymentInstrument p : payments) {
      double cost = p.processPayment(10000);
      total += cost;
      System.out.printf("%s: %.2f грн%n", p.getClass().getSimpleName(), cost);
    }
    System.out.printf("Сумарні витрати: %.2f грн%n", total);
  }
}
