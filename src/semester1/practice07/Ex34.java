package semester1.practice07;

public class Ex34 {
  static class ClientAccount {
    String iban, owner;
    double balance;

    public ClientAccount(String iban, String owner, double balance) {
      this.iban = iban;
      this.owner = owner;
      this.balance = balance;
    }

    public boolean transferTo(ClientAccount recipient, double amount) {
      if (recipient == null || recipient == this || amount <= 0 || balance < amount) return false;
      balance -= amount;
      recipient.balance += amount;
      return true;
    }

    public void printAccount() {
      System.out.printf("%s | %s | %.2f грн%n", iban, owner, balance);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ClientAccount a = new ClientAccount("UA1", "Іван", 10000),
        b = new ClientAccount("UA2", "Марія", 2000);
    System.out.println(a.transferTo(b, 3500));
    a.printAccount();
    b.printAccount();
    System.out.println(a.transferTo(a, 100));
    System.out.println(a.transferTo(b, 20000));
  }
}
