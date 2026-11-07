package semester1.practice07;

public class Ex39 {
  static class Vector3D {
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }

    public Vector3D() {
      this(0, 0, 0);
    }

    public Vector3D add(Vector3D other) {
      return new Vector3D(x + other.x, y + other.y, z + other.z);
    }

    public double dotProduct(Vector3D other) {
      return x * other.x + y * other.y + z * other.z;
    }

    public Vector3D crossProduct(Vector3D other) {
      return new Vector3D(
          y * other.z - z * other.y, z * other.x - x * other.z, x * other.y - y * other.x);
    }

    public boolean isOrthogonalTo(Vector3D other) {
      return Math.abs(dotProduct(other)) < 1e-9;
    }

    public boolean isEqualTo(Vector3D other) {
      return other != null && x == other.x && y == other.y && z == other.z;
    }

    public String toString() {
      return "(" + x + "; " + y + "; " + z + ")";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Vector3D a = new Vector3D(1, 0, 0), b = new Vector3D(0, 1, 0);
    System.out.println(a.add(b));
    System.out.println(a.dotProduct(b));
    System.out.println(a.crossProduct(b));
    System.out.println(a.isOrthogonalTo(b));
    System.out.println(a.isEqualTo(new Vector3D(1, 0, 0)));
    System.out.println(new Vector3D());
  }
}
