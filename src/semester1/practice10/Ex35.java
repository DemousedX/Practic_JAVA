package semester1.practice10;

public class Ex35 {

  interface MetricSpaceElement {
    double distanceTo(MetricSpaceElement other);

    double getNorm();
  }

  public static final class ImmutableVector3D implements MetricSpaceElement {
    private final double x, y, z;

    ImmutableVector3D(double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    @Override
    public double getNorm() {
      return Math.hypot(Math.hypot(x, y), z);
    }

    @Override
    public double distanceTo(MetricSpaceElement other) {
      if (!(other instanceof ImmutableVector3D v))
        throw new IllegalArgumentException("Потрібен 3D-вектор");
      return Math.hypot(Math.hypot(x - v.x, y - v.y), z - v.z);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    MetricSpaceElement[] points = {new ImmutableVector3D(1, 2, 2), new ImmutableVector3D(4, 6, 2)};
    for (MetricSpaceElement p : points) System.out.println("Норма: " + p.getNorm());
    System.out.println("Відстань: " + points[0].distanceTo(points[1]));
  }
}
