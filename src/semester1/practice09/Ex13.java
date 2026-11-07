package semester1.practice09;

public class Ex13 {
  static class BankAccount {
    private final String iban;
    private double balance;

    public BankAccount(String iban, double balance) {
      this.iban = iban;
      this.balance = Math.max(0, balance);
    }

    public void deposit(double amount) {
      if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
      if (amount <= 0 || amount > balance) return false;
      balance -= amount;
      return true;
    }

    public String toString() {
      return iban + " | " + balance + " грн";
    }
  }

  static class PlasticCard {
    private final String cardNumber, expiryDate;
    private boolean blocked;
    private final BankAccount linkedAccount;

    public PlasticCard(String cardNumber, String expiryDate, BankAccount linkedAccount) {
      this.cardNumber = cardNumber;
      this.expiryDate = expiryDate;
      this.linkedAccount = linkedAccount;
    }

    public void setBlocked(boolean blocked) {
      this.blocked = blocked;
    }

    public boolean payAtTerminal(double amount) {
      return !blocked && linkedAccount.withdraw(amount);
    }

    public String toString() {
      return "**** "
          + cardNumber.substring(Math.max(0, cardNumber.length() - 4))
          + " | "
          + expiryDate
          + " | blocked="
          + blocked
          + " | "
          + linkedAccount;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    BankAccount account = new BankAccount("UA1", 5000);
    PlasticCard a = new PlasticCard("1234567812341111", "12/28", account),
        b = new PlasticCard("1234567812342222", "12/28", account);
    System.out.println(a.payAtTerminal(1000));
    System.out.println(b.payAtTerminal(500));
    a.setBlocked(true);
    System.out.println(a.payAtTerminal(100));
    System.out.println(a);
    System.out.println(b);
  }
}
