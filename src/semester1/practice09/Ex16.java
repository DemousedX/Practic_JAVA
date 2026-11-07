package semester1.practice09;

public class Ex16 {
  static class TemperatureSensor {
    private double currentTemp;

    public TemperatureSensor(double currentTemp) {
      this.currentTemp = currentTemp;
    }

    public double read() {
      return currentTemp;
    }

    public void set(double currentTemp) {
      this.currentTemp = currentTemp;
    }
  }

  static class HeatingUnit {
    private boolean heatingOn;
    private double powerKw;

    public HeatingUnit(double powerKw) {
      this.powerKw = powerKw;
    }

    public void setHeatingOn(boolean heatingOn) {
      this.heatingOn = heatingOn;
    }

    public String toString() {
      return "on=" + heatingOn + " | " + powerKw + " kW";
    }
  }

  static class ClimateController {
    private final TemperatureSensor sensor;
    private final HeatingUnit heatingUnit;
    private double targetTemp;

    public ClimateController(TemperatureSensor sensor, HeatingUnit heatingUnit, double targetTemp) {
      this.sensor = sensor;
      this.heatingUnit = heatingUnit;
      this.targetTemp = targetTemp;
    }

    public void regulate() {
      double t = sensor.read();
      if (t < targetTemp - 0.5) heatingUnit.setHeatingOn(true);
      else if (t >= targetTemp) heatingUnit.setHeatingOn(false);
    }

    public String toString() {
      return "Room=" + sensor.read() + " | target=" + targetTemp + " | " + heatingUnit;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    TemperatureSensor s = new TemperatureSensor(19);
    ClimateController c = new ClimateController(s, new HeatingUnit(2), 21);
    for (double t : new double[] {19, 20.7, 21, 20.7, 20.4}) {
      s.set(t);
      c.regulate();
      System.out.println(c);
    }
  }
}
