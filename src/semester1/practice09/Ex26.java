package semester1.practice09;

public final class Ex26 {
  private Ex26() {}

  abstract static class AbstractPowerPlant {
    private final String stationName;
    protected double baseCapacityMw;

    AbstractPowerPlant(String n, double c) {
      stationName = n;
      baseCapacityMw = Math.max(0, c);
    }

    public abstract double generateMegawatts();

    public double calculateDailyProfit(double tariff) {
      return generateMegawatts() * 24 * tariff;
    }

    public String toString() {
      return stationName
          + ": "
          + generateMegawatts()
          + " MW, profit="
          + calculateDailyProfit(100)
          + " грн/day";
    }
  }

  static final class SolarPowerPlant extends AbstractPowerPlant {
    private final double sunIntensityFactor;

    SolarPowerPlant(String n, double c, double s) {
      super(n, c);
      sunIntensityFactor = Math.max(0, Math.min(1, s));
    }

    public double generateMegawatts() {
      return baseCapacityMw * sunIntensityFactor;
    }
  }

  static final class WindPowerPlant extends AbstractPowerPlant {
    private final double windSpeedMs;

    WindPowerPlant(String n, double c, double s) {
      super(n, c);
      windSpeedMs = s;
    }

    public double generateMegawatts() {
      return windSpeedMs < 3 || windSpeedMs > 25
          ? 0
          : baseCapacityMw * Math.min(1, windSpeedMs / 15);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new SolarPowerPlant("SolarPowerPlant", 20, .8));
    System.out.println(new WindPowerPlant("WindPowerPlant", 30, 12));
  }
}
