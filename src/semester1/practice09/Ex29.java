package semester1.practice09;

public final class Ex29 {
  private Ex29() {}

  abstract static class AbstractTransaction {
    private final String txId;
    protected final double amount;

    AbstractTransaction(String txId, double a) {
      this.txId = txId;
      amount = Math.max(0, a);
    }

    public abstract double calculateCommission();

    public final double getTotalDebit() {
      return amount + calculateCommission();
    }

    public String toString() {
      return txId
          + ": amount="
          + amount
          + ", fee="
          + calculateCommission()
          + ", getTotalDebit="
          + getTotalDebit();
    }
  }

  static final class DomesticTransfer extends AbstractTransaction {
    DomesticTransfer(String i, double a) {
      super(i, a);
    }

    public double calculateCommission() {
      return Math.max(5, amount * .005);
    }
  }

  static final class CryptoTransfer extends AbstractTransaction {
    private final double networkGasFee;

    CryptoTransfer(String i, double a, double g) {
      super(i, a);
      networkGasFee = Math.max(0, g);
    }

    public double calculateCommission() {
      return networkGasFee;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new DomesticTransfer("TX-1", 500));
    System.out.println(new CryptoTransfer("TX-2", 500, .0004));
  }
}
