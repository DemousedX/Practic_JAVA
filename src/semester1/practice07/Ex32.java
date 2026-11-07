package semester1.practice07;

public class Ex32 {
  static class PhysicsEngine {
    private PhysicsEngine() {}

    public static final double G = 9.80665, SPEED_OF_LIGHT = 299792458.0;

    public static double freeFallDistance(double seconds) {
      return G * seconds * seconds / 2;
    }

    public static double kineticEnergy(double massKg, double velocityMs) {
      return massKg * velocityMs * velocityMs / 2;
    }

    public static double restEnergy(double massKg) {
      return massKg * SPEED_OF_LIGHT * SPEED_OF_LIGHT;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(PhysicsEngine.restEnergy(0.001));
    System.out.println(PhysicsEngine.freeFallDistance(5));
    System.out.println(PhysicsEngine.kineticEnergy(10, 3));
  }
}
