package semester1.practice07;

public class Ex12 {
  static class SmartBulb {
    private int brightness, colorTemp;
    private boolean isOn;

    public SmartBulb(int brightness, int colorTemp, boolean isOn) {
      this.brightness = Math.max(0, Math.min(100, brightness));
      this.colorTemp = Math.max(2700, Math.min(6500, colorTemp));
      this.isOn = isOn;
    }

    public SmartBulb(int brightness) {
      this(brightness, 4000, true);
    }

    public SmartBulb() {
      this(50);
    }

    public void printStatus() {
      System.out.printf("%d%% | %d K | %s%n", brightness, colorTemp, isOn);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new SmartBulb().printStatus();
    new SmartBulb(80).printStatus();
    new SmartBulb(200, 1000, false).printStatus();
  }
}
