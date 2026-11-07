package semester1.practice09;

public class Ex6 {
  static class HighSecuritySafe {
    private int pinCode;
    private double storedCash;
    private int failedAttempts;
    private boolean permanentlyBlocked;

    public HighSecuritySafe(int pinCode, double storedCash) {
      this.pinCode = pinCode;
      this.storedCash = Math.max(0, storedCash);
    }

    private boolean checkAccess(int enteredPin) {
      if (permanentlyBlocked) return false;
      if (enteredPin != pinCode) {
        failedAttempts++;
        if (failedAttempts >= 3) permanentlyBlocked = true;
        return false;
      }
      failedAttempts = 0;
      return true;
    }

    public boolean putCash(int pin, double amount) {
      if (!checkAccess(pin) || amount <= 0) return false;
      storedCash += amount;
      return true;
    }

    public boolean takeCash(int pin, double amount) {
      if (!checkAccess(pin) || amount <= 0 || amount > storedCash) return false;
      storedCash -= amount;
      return true;
    }

    public String toString() {
      return "Cash="
          + storedCash
          + " | failures="
          + failedAttempts
          + " | blocked="
          + permanentlyBlocked;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    HighSecuritySafe s = new HighSecuritySafe(1234, 500);
    System.out.println(s.putCash(1234, 100));
    System.out.println(s.takeCash(1234, 50));
    for (int i = 0; i < 3; i++) s.takeCash(1111, 10);
    System.out.println(s.putCash(1234, 100));
    System.out.println(s);
  }
}
