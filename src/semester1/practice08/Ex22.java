package semester1.practice08;

public class Ex22 {
  static class Appliance {
    private String model;
    private double powerWatts;

    public Appliance(String model, double powerWatts) {
      this.model = model;
      this.powerWatts = Math.max(0, powerWatts);
    }

    public double getDailyConsumptionKWh(int hours) {
      return powerWatts * Math.max(0, hours) / 1000;
    }

    public String toString() {
      return model + " | " + powerWatts + " W | за 8 годин: " + getDailyConsumptionKWh(8) + " kWh";
    }
  }

  static class EcoHeater extends Appliance {
    boolean ecoModeActive;

    public EcoHeater(String model, double powerWatts, boolean ecoModeActive) {
      super(model, powerWatts);
      this.ecoModeActive = ecoModeActive;
    }

    @Override
    public double getDailyConsumptionKWh(int hours) {
      return super.getDailyConsumptionKWh(hours) * (ecoModeActive ? 0.75 : 1);
    }

    @Override
    public String toString() {
      return super.toString() + " | eco=" + ecoModeActive;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new Appliance("Обігрівач", 2000));
    System.out.println(new EcoHeater("Eco", 2000, true));
  }
}
