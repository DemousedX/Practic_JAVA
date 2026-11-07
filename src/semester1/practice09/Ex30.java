package semester1.practice09;

public final class Ex30 {
  private Ex30() {}

  abstract static class Solid3D {
    private final String materialName;
    private final double densityKgPerM3;

    Solid3D(String m, double d) {
      materialName = m;
      densityKgPerM3 = Math.max(0, d);
    }

    public abstract double getVolume();

    public abstract double getSurfaceArea();

    public final double getMassKg() {
      return densityKgPerM3 * getVolume();
    }

    public String toString() {
      return materialName
          + ": V="
          + getVolume()
          + " m3, S="
          + getSurfaceArea()
          + " m2, getMassKg="
          + getMassKg()
          + " kg";
    }
  }

  static final class Sphere3D extends Solid3D {
    private final double r;

    Sphere3D(String m, double d, double r) {
      super(m, d);
      this.r = Math.max(0, r);
    }

    public double getVolume() {
      return 4 * Math.PI * r * r * r / 3;
    }

    public double getSurfaceArea() {
      return 4 * Math.PI * r * r;
    }
  }

  static final class Cylinder3D extends Solid3D {
    private final double r, h;

    Cylinder3D(String m, double d, double r, double h) {
      super(m, d);
      this.r = Math.max(0, r);
      this.h = Math.max(0, h);
    }

    public double getVolume() {
      return Math.PI * r * r * h;
    }

    public double getSurfaceArea() {
      return 2 * Math.PI * r * (r + h);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new Sphere3D("steel", 7850, .2));
    System.out.println(new Cylinder3D("gold", 19300, .1, .5));
  }
}
