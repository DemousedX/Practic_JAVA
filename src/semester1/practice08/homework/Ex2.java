package semester1.practice08.homework;

public final class Ex2 {
  private Ex2() {}

  private static class BankAccount {
    private final String iban;
    private final String owner;
    protected double balance;

    BankAccount(String iban, String owner, double balance) {
      this.iban = iban;
      this.owner = owner;
      this.balance = Math.max(0, balance);
    }

    double getBalance() {
      return balance;
    }

    void deposit(double amount) {
      if (amount > 0) balance += amount;
    }

    boolean withdraw(double amount) {
      if (amount > 0 && amount <= balance) {
        balance -= amount;
        return true;
      }
      System.out.println("Зняття відхилено");
      return false;
    }

    @Override
    public String toString() {
      return String.format("Рахунок[%s | Власник: %s | Баланс: %.2f грн]", iban, owner, balance);
    }
  }

  private static final class SavingsAccount extends BankAccount {
    private final double rate, minimum;

    SavingsAccount(String iban, String owner, double balance, double rate, double minimum) {
      super(iban, owner, balance);
      this.rate = rate;
      this.minimum = minimum;
    }

    @Override
    boolean withdraw(double amount) {
      if (amount <= 0 || balance - amount < minimum) {
        System.out.printf("Відмова: мінімальний залишок %.2f грн%n", minimum);
        return false;
      }
      return super.withdraw(amount);
    }

    void applyInterest() {
      if (rate > 0) deposit(balance * rate / 100);
    }

    @Override
    public String toString() {
      return String.format(
          "SavingsAccount{%s, Ставка: %.1f%%, Мін.залишок: %.2f грн}",
          super.toString(), rate, minimum);
    }
  }

  private static final class CreditAccount extends BankAccount {
    private final double limit, feePercent;

    CreditAccount(String iban, String owner, double balance, double limit, double feePercent) {
      super(iban, owner, balance);
      this.limit = limit;
      this.feePercent = feePercent;
    }

    @Override
    boolean withdraw(double amount) {
      if (amount <= 0) return false;
      if (amount <= balance) return super.withdraw(amount);
      double borrowed = amount - Math.max(0, balance),
          fee = borrowed * feePercent / 100,
          next = balance - amount - fee;
      if (next < -limit) {
        System.out.println("Відмова: кредитний ліміт перевищено");
        return false;
      }
      balance = next;
      return true;
    }

    double getCurrentDebt() {
      return Math.max(0, -balance);
    }

    @Override
    public String toString() {
      return String.format(
          "CreditAccount{%s, Ліміт: %.2f грн, Борг: %.2f грн}",
          super.toString(), limit, getCurrentDebt());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    SavingsAccount savings = new SavingsAccount("UA101", "Олена Коваль", 5000, 12, 1000);
    System.out.println(savings);
    savings.withdraw(4500);
    savings.applyInterest();
    System.out.println(savings);
    CreditAccount credit = new CreditAccount("UA202", "Максим Бондар", 2000, 10000, 2);
    System.out.println(credit);
    credit.withdraw(5000);
    System.out.println(credit);
  }
}
