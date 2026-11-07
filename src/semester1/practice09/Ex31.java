package semester1.practice09;

public final class Ex31 {
  private Ex31() {}

  abstract static class AbstractSensor {
    private final String location;
    private final double minSafe, maxSafe;

    AbstractSensor(String l, double a, double b) {
      location = l;
      minSafe = a;
      maxSafe = b;
    }

    public abstract double readValue();

    public abstract String getUnit();

    public final boolean isAlarmTriggered() {
      double value = readValue();
      return value < minSafe || value > maxSafe;
    }

    public String toString() {
      return location
          + ": "
          + readValue()
          + " "
          + getUnit()
          + ", isAlarmTriggered="
          + isAlarmTriggered();
    }
  }

  static final class PressureSensor extends AbstractSensor {
    private final double pressure, calibration;

    PressureSensor(String l, double p, double k) {
      super(l, 1, 10);
      pressure = p;
      calibration = k;
    }

    public double readValue() {
      return pressure * calibration;
    }

    public String getUnit() {
      return "bar";
    }
  }

  static final class RadiationSensor extends AbstractSensor {
    private final double level;

    RadiationSensor(String l, double x) {
      super(l, 0, .5);
      level = x;
    }

    public double readValue() {
      return level;
    }

    public String getUnit() {
      return "uSv/h";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new PressureSensor("Boiler", 7, 1.02));
    System.out.println(new RadiationSensor("Lab", .8));
  }
}
