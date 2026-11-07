package semester1.practice06;

public class Ex32 {
  static class SmartDoorLock {
    private int pinCode = 1234;
    private boolean isLocked = true;
    private int failedAttempts = 0;

    public void enterPin(int enteredPin) {
      if (failedAttempts >= 3) {
        System.out.println("СИСТЕМА ЗАБЛОКОВАНА! Викличте охорону");
        return;
      }
      if (enteredPin == pinCode) {
        isLocked = false;
        failedAttempts = 0;
        System.out.println("Відчинено");
      } else {
        failedAttempts++;
        System.out.println("Хибний PIN, спроб: " + failedAttempts);
      }
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    SmartDoorLock l = new SmartDoorLock();
    l.enterPin(1111);
    l.enterPin(2222);
    l.enterPin(3333);
    l.enterPin(1234);
  }
}
