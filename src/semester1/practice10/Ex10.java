package semester1.practice10;

public class Ex10 {

  interface EnergyConvertible {
    double SPEED_OF_LIGHT = 299_792_458.0;
    double JOULES_PER_KWH = 3_600_000.0;

    double getEnergyJoules();

    default double getEnergyKwh() {
      return getEnergyJoules() / JOULES_PER_KWH;
    }
  }

  static class KineticBody implements EnergyConvertible {
    private final double mass, speed;

    KineticBody(double mass, double speed) {
      this.mass = mass;
      this.speed = speed;
    }

    @Override
    public double getEnergyJoules() {
      return mass * speed * speed / 2;
    }
  }

  static class BatteryCell implements EnergyConvertible {
    private final double wattHours;

    BatteryCell(double wattHours) {
      this.wattHours = wattHours;
    }

    @Override
    public double getEnergyJoules() {
      return wattHours * 3600;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    EnergyConvertible[] items = {new KineticBody(1000, 20), new BatteryCell(100)};
    for (EnergyConvertible e : items)
      System.out.printf("%.2f Дж = %.6f кВт·год%n", e.getEnergyJoules(), e.getEnergyKwh());
    System.out.println("Швидкість світла: " + EnergyConvertible.SPEED_OF_LIGHT);
  }
}
