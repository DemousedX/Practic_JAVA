package semester1.practice09;

public class Ex3 {
  static class CryptoVault {
    private final String walletAddress;
    private String secretRecoveryPhrase;
    private double btcBalance;
    private boolean locked = true;

    public CryptoVault(String walletAddress, String secretRecoveryPhrase, double btcBalance) {
      this.walletAddress = walletAddress;
      this.secretRecoveryPhrase = secretRecoveryPhrase;
      this.btcBalance = Math.max(0, btcBalance);
    }

    public boolean unlock(String phrase) {
      if (!secretRecoveryPhrase.equals(phrase)) return false;
      locked = false;
      return true;
    }

    public void lock() {
      locked = true;
    }

    public boolean sendBtc(double amount, String destination) {
      if (locked
          || amount <= 0
          || amount > btcBalance
          || destination == null
          || destination.isBlank()) return false;
      btcBalance -= amount;
      return true;
    }

    public String toString() {
      return walletAddress + " | locked=" + locked + " | " + btcBalance + " BTC";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    CryptoVault v = new CryptoVault("bc1-test", "secret phrase", 0.75);
    System.out.println(v.sendBtc(0.1, "bc1-other"));
    System.out.println(v.unlock("bad"));
    System.out.println(v.unlock("secret phrase"));
    System.out.println(v.sendBtc(0.2, "bc1-other"));
    v.lock();
    System.out.println(v);
  }
}
