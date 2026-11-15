package semester1.practice10.homework;

public class Ex2 {

  interface CashbackCapable {
    double MAX_CASHBACK_UAH = 500;

    double getCashbackRate();

    default double calculateCashback(double baseAmount) {
      return Math.min(MAX_CASHBACK_UAH, baseAmount * getCashbackRate());
    }
  }

  interface Refundable {
    boolean requestRefund(String reason);

    boolean isRefunded();
  }

  interface BlockchainVerifiable {
    String getTxHash();

    int getConfirmations();

    default boolean isFinalized() {
      return getConfirmations() >= 12;
    }
  }

  abstract static class AbstractPaymentTransaction {
    private final String txId;
    private final double baseAmountUah;
    private boolean processed;

    AbstractPaymentTransaction(String txId, double amount) {
      this.txId = txId;
      baseAmountUah = amount;
    }

    public abstract double calculateFee();

    public abstract String getPaymentChannel();

    public final boolean process() {
      if (!Double.isFinite(baseAmountUah) || baseAmountUah <= 0 || processed) return false;
      processed = true;
      return true;
    }

    public final double getTotalCharged() {
      return baseAmountUah + calculateFee();
    }

    public boolean isProcessed() {
      return processed;
    }

    public double getBaseAmountUah() {
      return baseAmountUah;
    }

    public String getTxId() {
      return txId;
    }
  }

  static class PremiumCardPayment extends AbstractPaymentTransaction
      implements CashbackCapable, Refundable {
    private final String maskedPan;
    private boolean refunded;

    PremiumCardPayment(String id, double amount, String maskedPan) {
      super(id, amount);
      this.maskedPan = maskedPan;
    }

    @Override
    public double calculateFee() {
      return getBaseAmountUah() * 0.01;
    }

    @Override
    public String getPaymentChannel() {
      return "Преміальна картка " + maskedPan;
    }

    @Override
    public double getCashbackRate() {
      return 0.03;
    }

    @Override
    public boolean requestRefund(String reason) {
      if (!isProcessed() || refunded || reason == null || reason.isBlank()) return false;
      refunded = true;
      return true;
    }

    @Override
    public boolean isRefunded() {
      return refunded;
    }
  }

  static class CryptoUsdtPayment extends AbstractPaymentTransaction
      implements CashbackCapable, BlockchainVerifiable {
    private final String txHash;
    private final int confirmations;

    CryptoUsdtPayment(String id, double amount, String txHash, int confirmations) {
      super(id, amount);
      this.txHash = txHash;
      this.confirmations = confirmations;
    }

    @Override
    public double calculateFee() {
      return 40;
    }

    @Override
    public String getPaymentChannel() {
      return "USDT TRC-20";
    }

    @Override
    public double getCashbackRate() {
      return 0.01;
    }

    @Override
    public String getTxHash() {
      return txHash;
    }

    @Override
    public int getConfirmations() {
      return confirmations;
    }
  }

  public static final class TaxTreasuryPayment extends AbstractPaymentTransaction
      implements Refundable {
    private final String taxCode;
    private boolean refunded;

    TaxTreasuryPayment(String id, double amount, String taxCode) {
      super(id, amount);
      this.taxCode = taxCode;
    }

    @Override
    public double calculateFee() {
      return 0;
    }

    @Override
    public String getPaymentChannel() {
      return "Казначейство " + taxCode;
    }

    @Override
    public boolean requestRefund(String reason) {
      if (!isProcessed() || refunded || reason == null || reason.isBlank()) return false;
      refunded = true;
      return true;
    }

    @Override
    public boolean isRefunded() {
      return refunded;
    }
  }

  public static double[] auditLedger(AbstractPaymentTransaction[] ledger) {
    double turnover = 0, fees = 0, cashback = 0;
    for (AbstractPaymentTransaction tx : ledger) {
      if (!tx.process()) {
        System.out.println(tx.getTxId() + ": платіж відхилено");
        continue;
      }
      turnover += tx.getBaseAmountUah();
      fees += tx.calculateFee();
      System.out.printf(
          "%s | %s | Сума: %.2f, комісія: %.2f, списано: %.2f%n",
          tx.getTxId(),
          tx.getPaymentChannel(),
          tx.getBaseAmountUah(),
          tx.calculateFee(),
          tx.getTotalCharged());
      if (tx instanceof CashbackCapable c) {
        double bonus = c.calculateCashback(tx.getBaseAmountUah());
        cashback += bonus;
        System.out.printf("Кешбек: %.2f%n", bonus);
      }
      if (tx instanceof BlockchainVerifiable b)
        System.out.println(
            "Hash="
                + b.getTxHash()
                + ", підтверджень="
                + b.getConfirmations()
                + ", завершено="
                + b.isFinalized());
      if (tx instanceof Refundable r)
        System.out.println("Тестове повернення: " + r.requestRefund("Навчальна перевірка"));
    }
    System.out.printf(
        "Валовий оборот: %.2f, комісії: %.2f, розрахований кешбек до повернень: %.2f%n",
        turnover, fees, cashback);
    return new double[] {turnover, fees, cashback};
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    AbstractPaymentTransaction[] ledger = {
      new PremiumCardPayment("TX-101", 20000, "**** 1234"),
      new CryptoUsdtPayment("TX-102", 8500, "0x9f8ac4", 18),
      new TaxTreasuryPayment("TX-103", 5000, "101")
    };
    auditLedger(ledger);
    System.out.println("Повторне проведення: " + ledger[0].process());
    System.out.println("Повторне повернення: " + ((Refundable) ledger[0]).requestRefund("Повтор"));
  }
}
