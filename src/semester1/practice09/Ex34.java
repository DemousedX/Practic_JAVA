package semester1.practice09;

public class Ex34 {
  abstract static class AbstractThruster {
    private final String thrusterId;

    public AbstractThruster(String thrusterId) {
      this.thrusterId = thrusterId;
    }

    public abstract double getThrustKn();

    public abstract double getFuelBurnRate();

    public String toString() {
      return thrusterId + " | " + getThrustKn() + " kN | fuel=" + getFuelBurnRate();
    }
  }

  static class ChemicalThruster extends AbstractThruster {
    private double thrustKn, fuelBurnRate;

    public ChemicalThruster(String id, double thrustKn, double fuelBurnRate) {
      super(id);
      this.thrustKn = thrustKn;
      this.fuelBurnRate = fuelBurnRate;
    }

    public double getThrustKn() {
      return thrustKn;
    }

    public double getFuelBurnRate() {
      return fuelBurnRate;
    }
  }

  static class IonThruster extends AbstractThruster {
    private double thrustKn, fuelBurnRate;

    public IonThruster(String id, double thrustKn, double fuelBurnRate) {
      super(id);
      this.thrustKn = thrustKn;
      this.fuelBurnRate = fuelBurnRate;
    }

    public double getThrustKn() {
      return thrustKn;
    }

    public double getFuelBurnRate() {
      return fuelBurnRate;
    }
  }

  static class Spacecraft {
    private final String shipName;
    private final double dryMassTons;
    private final AbstractThruster[] thrusters;
    private int count;

    public Spacecraft(String shipName, double dryMassTons, int capacity) {
      if (dryMassTons <= 0) throw new IllegalArgumentException("Маса має бути додатною");
      this.shipName = shipName;
      this.dryMassTons = dryMassTons;
      thrusters = new AbstractThruster[capacity];
    }

    public void addThruster(AbstractThruster thruster) {
      if (thruster != null && count < thrusters.length) thrusters[count++] = thruster;
    }

    public double getTotalThrustKn() {
      double sum = 0;
      for (int i = 0; i < count; i++) sum += thrusters[i].getThrustKn();
      return sum;
    }

    public double getInitialAcceleration() {
      return getTotalThrustKn() / dryMassTons;
    }

    public String toString() {
      return shipName
          + " | "
          + java.util.Arrays.toString(java.util.Arrays.copyOf(thrusters, count))
          + " | thrust="
          + getTotalThrustKn()
          + " kN | acceleration="
          + getInitialAcceleration()
          + " m/s^2";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Spacecraft s = new Spacecraft("Voyager", 10, 4);
    s.addThruster(new ChemicalThruster("C1", 120, 2));
    s.addThruster(new IonThruster("I1", 0.8, 0.001));
    System.out.println(s);
  }
}
