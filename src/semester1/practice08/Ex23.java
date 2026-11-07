package semester1.practice08;

public class Ex23 {
  static class Point2D {
    private double x, y;

    public Point2D(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public double getX() {
      return x;
    }

    public double getY() {
      return y;
    }

    public double distanceToOrigin() {
      return Math.hypot(x, y);
    }

    public String toString() {
      return "(" + x + "; " + y + ")";
    }
  }

  static class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
      super(x, y);
      this.z = z;
    }

    @Override
    public double distanceToOrigin() {
      return Math.sqrt(Math.pow(super.distanceToOrigin(), 2) + z * z);
    }

    @Override
    public String toString() {
      return "(" + getX() + "; " + getY() + "; " + z + ")";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (Point2D p : new Point2D[] {new Point2D(3, 4), new Point3D(3, 4, 12)})
      System.out.println(p + " | відстань: " + p.distanceToOrigin());
  }
}
