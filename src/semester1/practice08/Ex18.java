package semester1.practice08;

public class Ex18 {
  static class StandardTransfer {
    protected double amount;

    public StandardTransfer(double amount) {
      this.amount = Math.max(0, amount);
    }

    public double getFee() {
      return amount * 0.01;
    }

    public double getTotalWithFee() {
      return amount + getFee();
    }

    public String toString() {
      return "Transfer{amount="
          + amount
          + ", fee="
          + getFee()
          + ", total="
          + getTotalWithFee()
          + "}";
    }
  }

  static class InternationalTransfer extends StandardTransfer {
    private String countryCode;

    public InternationalTransfer(double amount, String countryCode) {
      super(amount);
      this.countryCode = countryCode;
    }

    @Override
    public double getFee() {
      return super.getFee() * 2 + 15;
    }

    @Override
    public String toString() {
      return countryCode + " | " + super.toString();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new StandardTransfer(5000));
    System.out.println(new InternationalTransfer(5000, "PL"));
  }
}
