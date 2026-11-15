package semester1.practice10;

public class Ex14 {

  interface Authenticatable {
    boolean verifySignature(String key);
  }

  interface Auditable {
    String getAuditTrail();
  }

  interface BlockchainSmartContract extends Authenticatable, Auditable {
    boolean executeContract(double gasLimit);
  }

  static class EscrowSmartContract implements BlockchainSmartContract {
    private final String expectedKey;
    private boolean verified, executed;
    private String audit = "Створено";

    EscrowSmartContract(String expectedKey) {
      this.expectedKey = expectedKey;
    }

    @Override
    public boolean verifySignature(String key) {
      verified = expectedKey.equals(key);
      audit += "; підпис=" + verified;
      return verified;
    }

    @Override
    public boolean executeContract(double gasLimit) {
      if (!verified || executed || gasLimit < 10) {
        audit += "; відмовлено";
        return false;
      }
      executed = true;
      audit += "; виконано";
      return true;
    }

    @Override
    public String getAuditTrail() {
      return audit;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    BlockchainSmartContract contract = new EscrowSmartContract("demo-key");
    System.out.println("Підпис: " + contract.verifySignature("demo-key"));
    System.out.println("Виконання: " + contract.executeContract(20));
    System.out.println(contract.getAuditTrail());
  }
}
