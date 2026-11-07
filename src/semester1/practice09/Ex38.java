package semester1.practice09;

public class Ex38 {
  static class EmergencySiren {
    private boolean sounding;

    public void activate() {
      sounding = true;
    }

    public boolean isSounding() {
      return sounding;
    }
  }

  static class SmartLab {
    private final EmergencySiren siren = new EmergencySiren();
    private final Ex31.AbstractSensor[] sensors;

    public SmartLab(Ex31.AbstractSensor[] sensors) {
      this.sensors = sensors.clone();
    }

    public void runDiagnostics() {
      for (Ex31.AbstractSensor sensor : sensors) {
        if (sensor == null) continue;
        System.out.println(sensor);
        if (sensor.isAlarmTriggered()) siren.activate();
      }
      System.out.println("Сирена: " + siren.isSounding());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    SmartLab lab =
        new SmartLab(
            new Ex31.AbstractSensor[] {
              new Ex31.PressureSensor("Boiler", 7, 1.02), new Ex31.RadiationSensor("Lab", 0.8)
            });
    lab.runDiagnostics();
  }
}
