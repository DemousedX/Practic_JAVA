package semester1.practice08;

public final class Ex5 {
  private Ex5() {}

  static class SensorNode {
    private String sensorId;
    protected double calibrationOffset;
    private double rawValue;

    SensorNode(String id, double raw, double offset) {
      sensorId = id;
      rawValue = raw;
      calibrationOffset = offset;
    }

    public String getSensorId() {
      return sensorId;
    }

    public double getCalibratedValue() {
      return rawValue + calibrationOffset;
    }

    @Override
    public String toString() {
      return String.format(
          "Sensor %s: raw=%.2f, calibrated=%.2f", sensorId, rawValue, getCalibratedValue());
    }
  }

  static class TemperatureSensor extends SensorNode {
    TemperatureSensor(String id, double raw, double offset) {
      super(id, raw, offset);
    }

    public void recalibrate(double offset) {
      calibrationOffset = offset;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 05 ---%n");

    TemperatureSensor sensor = new TemperatureSensor("T-17", 21.4, -0.6);
    System.out.println(sensor);
    sensor.recalibrate(0.2);
    System.out.println(sensor);
  }
}
