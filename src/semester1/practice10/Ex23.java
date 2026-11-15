package semester1.practice10;

public class Ex23 {

  abstract static class AbstractLabDevice {
    private final String inventoryCode;

    AbstractLabDevice(String code) {
      inventoryCode = code;
    }

    public abstract void performMeasurement();

    public String getInventoryCode() {
      return inventoryCode;
    }
  }

  interface Calibratable {
    void calibrate(double referenceValue);
  }

  interface SelfDiagnostic {
    boolean runSelfCheck();
  }

  static class ElectronicScale extends AbstractLabDevice implements Calibratable, SelfDiagnostic {
    private double reading = 100, correction;

    ElectronicScale() {
      super("S-01");
    }

    @Override
    public void calibrate(double referenceValue) {
      correction = referenceValue - reading;
    }

    @Override
    public boolean runSelfCheck() {
      return Double.isFinite(reading + correction);
    }

    @Override
    public void performMeasurement() {
      System.out.println("Маса: " + (reading + correction) + " г");
    }
  }

  static class GlassThermometer extends AbstractLabDevice {
    GlassThermometer() {
      super("T-01");
    }

    @Override
    public void performMeasurement() {
      System.out.println("Температура: 22 °C");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    for (AbstractLabDevice d :
        new AbstractLabDevice[] {new ElectronicScale(), new GlassThermometer()}) {
      System.out.println(d.getInventoryCode());
      if (d instanceof Calibratable c) c.calibrate(101);
      if (d instanceof SelfDiagnostic s) System.out.println("Самодіагностика: " + s.runSelfCheck());
      d.performMeasurement();
    }
  }
}
