package semester1.practice08.homework;

public final class Ex3 {
  private Ex3() {}

  private static class Vector2D {
    private double x, y;

    Vector2D(double x, double y) {
      this.x = x;
      this.y = y;
    }

    Vector2D() {
      this(0, 0);
    }

    double getX() {
      return x;
    }

    double getY() {
      return y;
    }

    void setX(double x) {
      this.x = x;
    }

    void setY(double y) {
      this.y = y;
    }

    double getLength() {
      return Math.hypot(x, y);
    }

    double dotProduct(Vector2D v) {
      return x * v.x + y * v.y;
    }

    @Override
    public String toString() {
      return String.format("Vector2D(%.2f; %.2f) |L|=%.2f", x, y, getLength());
    }
  }

  private static class Vector3D extends Vector2D {
    private double z;

    Vector3D(double x, double y, double z) {
      super(x, y);
      this.z = z;
    }

    double getZ() {
      return z;
    }

    void setZ(double z) {
      this.z = z;
    }

    @Override
    double getLength() {
      return Math.hypot(super.getLength(), z);
    }

    double dotProduct(Vector3D v) {
      return super.dotProduct(v) + z * v.z;
    }

    Vector3D crossProduct(Vector3D v) {
      return new Vector3D(
          getY() * v.z - z * v.getY(),
          z * v.getX() - getX() * v.z,
          getX() * v.getY() - getY() * v.getX());
    }

    @Override
    public String toString() {
      return String.format("Vector3D(%.2f; %.2f; %.2f) |L|=%.2f", getX(), getY(), z, getLength());
    }
  }

  private static final class ForceVector3D extends Vector3D {
    private final String name;

    ForceVector3D(String name, double x, double y, double z) {
      super(x, y, z);
      this.name = name;
    }

    double calculateWork(Vector3D displacement) {
      return dotProduct(displacement);
    }

    double calculateAcceleration(double mass) {
      return mass > 0 ? getLength() / mass : 0;
    }

    @Override
    public String toString() {
      return String.format("Force[name='%s', %s Н]", name, super.toString());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Vector2D a = new Vector2D(3, 4);
    Vector3D b = new Vector3D(3, 4, 12);
    Vector3D s = new Vector3D(2, 0, 5);
    ForceVector3D f = new ForceVector3D("Тяга ракети", 3, 4, 12);
    System.out.println(a);
    System.out.println(b);
    System.out.println("Робота: " + f.calculateWork(s));
    System.out.println("Прискорення: " + f.calculateAcceleration(2.5));
  }
}
