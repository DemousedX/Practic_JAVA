package semester1.practice08;

public final class Ex27 {
  private Ex27() {}

  static class PaymentCard {
    private String cardHolder;
    protected double balance;

    PaymentCard(String holder, double balance) {
      cardHolder = holder;
      this.balance = Math.max(0, balance);
    }

    public boolean pay(double amount) {
      if (amount <= 0 || amount > balance) return false;
      balance -= amount;
      return true;
    }

    @Override
    public String toString() {
      return cardHolder + ", balance=" + String.format("%.2f", balance);
    }
  }

  static class DebitCard extends PaymentCard {
    private double dailyLimit;

    DebitCard(String holder, double balance, double limit) {
      super(holder, balance);
      dailyLimit = limit;
    }

    @Override
    public boolean pay(double amount) {
      return amount <= dailyLimit && super.pay(amount);
    }
  }

  static class CashbackPlatinumCard extends DebitCard {
    private double cashbackPercent, accumulatedCashback;

    CashbackPlatinumCard(String holder, double balance, double limit, double cashback) {
      super(holder, balance, limit);
      cashbackPercent = cashback;
    }

    @Override
    public boolean pay(double amount) {
      boolean paid = super.pay(amount);
      if (paid) accumulatedCashback += amount * cashbackPercent / 100;
      return paid;
    }

    @Override
    public String toString() {
      return "Platinum{"
          + super.toString()
          + ", cashback="
          + String.format("%.2f", accumulatedCashback)
          + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 27 ---%n");

    CashbackPlatinumCard card = new CashbackPlatinumCard("Олександр", 20000, 5000, 2);
    System.out.println("Paid: " + card.pay(1200));
    System.out.println(card);
  }
}
