package semester1.practice10;

public class Ex26 {

  interface Rechargeable {
    void chargeToFull();
  }

  static class Laptop implements Rechargeable {
    private int charge = 20;

    @Override
    public void chargeToFull() {
      charge = 100;
      System.out.println("Ноутбук: " + charge + "%");
    }
  }

  static class ElectricScooter implements Rechargeable {
    private int charge = 30;

    @Override
    public void chargeToFull() {
      charge = 100;
      System.out.println("Самокат: " + charge + "%");
    }
  }

  static class SmartWatch implements Rechargeable {
    private int charge = 10;

    @Override
    public void chargeToFull() {
      charge = 100;
      System.out.println("Годинник: " + charge + "%");
    }
  }

  static class DesktopMonitor {}

  static class WiredPrinter {}

  public static int chargeAllPossible(Object[] items) {
    int count = 0;
    for (Object item : items)
      if (item instanceof Rechargeable r) {
        r.chargeToFull();
        count++;
      }
    return count;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    System.out.println(
        "Заряджено: "
            + chargeAllPossible(
                new Object[] {
                  new Laptop(),
                  new DesktopMonitor(),
                  new ElectricScooter(),
                  new SmartWatch(),
                  new WiredPrinter(),
                  null
                }));
  }
}
