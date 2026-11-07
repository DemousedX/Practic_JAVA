package semester1.practice09;

public class Ex11 {
  static class Battery {
    private int capacityMah, chargePercent;

    public Battery(int capacityMah, int chargePercent) {
      this.capacityMah = Math.max(1, capacityMah);
      this.chargePercent = Math.max(0, Math.min(100, chargePercent));
    }

    public void drain(int percent) {
      if (percent > 0) chargePercent = Math.max(0, chargePercent - percent);
    }

    public void charge(int percent) {
      if (percent > 0) chargePercent = Math.min(100, chargePercent + percent);
    }

    public int getChargePercent() {
      return chargePercent;
    }

    public String toString() {
      return capacityMah + " mAh | " + chargePercent + "%";
    }
  }

  static class Display {
    private double diagonalInches;
    private int brightnessPercent;

    public Display(double diagonalInches, int brightnessPercent) {
      this.diagonalInches = diagonalInches;
      this.brightnessPercent = Math.max(10, Math.min(100, brightnessPercent));
    }

    public int getBrightnessPercent() {
      return brightnessPercent;
    }

    public String toString() {
      return diagonalInches + " in | brightness=" + brightnessPercent + "%";
    }
  }

  static class SmartDevice {
    private final Battery battery;
    private final Display display;
    private boolean poweredOn;

    public SmartDevice(Battery battery, Display display) {
      this.battery = battery;
      this.display = display;
      poweredOn = battery.getChargePercent() > 0;
    }

    public void watchVideo(int minutes) {
      if (!poweredOn || minutes <= 0) return;
      int blocks = minutes / 10;
      int drain = blocks * (display.getBrightnessPercent() > 70 ? 2 : 1);
      battery.drain(drain);
      if (battery.getChargePercent() == 0) poweredOn = false;
    }

    public String toString() {
      return battery + " | " + display + " | on=" + poweredOn;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    SmartDevice a = new SmartDevice(new Battery(5000, 80), new Display(6.1, 80));
    a.watchVideo(30);
    System.out.println(a);
    SmartDevice b = new SmartDevice(new Battery(5000, 2), new Display(6.1, 70));
    b.watchVideo(20);
    System.out.println(b);
  }
}
