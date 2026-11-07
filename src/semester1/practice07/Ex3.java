package semester1.practice07;

public class Ex3 {
  static class BankAccount {
    private String accountNumber, ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
      this.accountNumber = accountNumber;
      this.ownerName = ownerName;
      balance = Math.max(0, initialBalance);
    }

    public void deposit(double amount) {
      if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
      if (amount <= 0 || amount > balance) return false;
      balance -= amount;
      return true;
    }

    public void printAccount() {
      System.out.printf("%s | %s | %.2f грн%n", accountNumber, ownerName, balance);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    BankAccount a = new BankAccount("UA1001", "Іван", 1000);
    a.deposit(500);
    System.out.println(a.withdraw(2000));
    System.out.println(a.withdraw(300));
    a.printAccount();
  }
}
