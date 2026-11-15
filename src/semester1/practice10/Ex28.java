package semester1.practice10;

public class Ex28 {

  abstract static class ShipModule {
    final String name;
    boolean damaged;

    ShipModule(String name, boolean damaged) {
      this.name = name;
      this.damaged = damaged;
    }
  }

  static class ShieldGenerator extends ShipModule {
    private int energy;

    ShieldGenerator(boolean damaged) {
      super("Щити", damaged);
    }

    void rechargeShields(int megajoules) {
      if (!damaged) energy += Math.max(0, megajoules);
      System.out.println("Енергія щитів: " + energy);
    }
  }

  static class WarpDrive extends ShipModule {
    WarpDrive(boolean damaged) {
      super("Варп-двигун", damaged);
    }

    boolean checkAntimatterContainment() {
      return !damaged;
    }
  }

  static class LifeSupportModule extends ShipModule {
    LifeSupportModule(boolean damaged) {
      super("Життєзабезпечення", damaged);
    }

    double getOxygenPercent() {
      return damaged ? 15 : 21;
    }
  }

  static void runShipInspection(ShipModule[] modules) {
    for (ShipModule m : modules) {
      System.out.println(m.name + ", пошкоджено: " + m.damaged);
      if (m instanceof ShieldGenerator s) s.rechargeShields(100);
      else if (m instanceof WarpDrive w)
        System.out.println("Утримання антиматерії: " + w.checkAntimatterContainment());
      else if (m instanceof LifeSupportModule l)
        System.out.println("Кисень: " + l.getOxygenPercent() + "%");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    runShipInspection(
        new ShipModule[] {
          new ShieldGenerator(false), new WarpDrive(true), new LifeSupportModule(false)
        });
  }
}
