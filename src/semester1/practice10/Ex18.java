package semester1.practice10;

public class Ex18 {

  abstract static class AbstractSmartAppliance {
    private final String room, model;
    protected boolean poweredOn;

    AbstractSmartAppliance(String room, String model) {
      this.room = room;
      this.model = model;
    }

    public void setPoweredOn(boolean poweredOn) {
      this.poweredOn = poweredOn;
    }

    public abstract double getCurrentWatts();

    @Override
    public String toString() {
      return room + ": " + model;
    }
  }

  interface Dimmable {
    void setBrightness(int percent);
  }

  interface HeatingCapable {
    void setTargetTemperature(double celsius);
  }

  static class SmartLedChandelier extends AbstractSmartAppliance implements Dimmable {
    private int brightness = 100;

    SmartLedChandelier(String room) {
      super(room, "LED");
    }

    @Override
    public void setBrightness(int percent) {
      brightness = Math.max(0, Math.min(100, percent));
    }

    @Override
    public double getCurrentWatts() {
      return poweredOn ? 60 * brightness / 100.0 : 0;
    }
  }

  static class SmartUnderfloorHeating extends AbstractSmartAppliance implements HeatingCapable {
    private double target = 22;

    SmartUnderfloorHeating(String room) {
      super(room, "Тепла підлога");
    }

    @Override
    public void setTargetTemperature(double celsius) {
      target = Math.max(5, Math.min(35, celsius));
    }

    @Override
    public double getCurrentWatts() {
      return poweredOn ? 100 * Math.max(0, target - 18) : 0;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    SmartLedChandelier lamp = new SmartLedChandelier("Кімната");
    lamp.setBrightness(50);
    SmartUnderfloorHeating heater = new SmartUnderfloorHeating("Ванна");
    heater.setTargetTemperature(25);
    double total = 0;
    for (AbstractSmartAppliance a : new AbstractSmartAppliance[] {lamp, heater}) {
      a.setPoweredOn(true);
      total += a.getCurrentWatts();
      System.out.println(a + ": " + a.getCurrentWatts() + " Вт");
    }
    System.out.println("Разом: " + total + " Вт");
  }
}
