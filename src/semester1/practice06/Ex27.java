package semester1.practice06;

public class Ex27 {
  static class BankAccount {
    private String accountNumber = "UA1";
    private double balance;

    public void deposit(double amount) {
      if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
      if (amount <= 0 || amount > balance) return false;
      balance -= amount;
      return true;
    }

    public double getBalance() {
      return balance;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    BankAccount a = new BankAccount();
    a.deposit(1000);
    System.out.println(a.withdraw(1200));
    System.out.println(a.getBalance());
    System.out.println(a.withdraw(250));
    System.out.println(a.getBalance());
  }
}
