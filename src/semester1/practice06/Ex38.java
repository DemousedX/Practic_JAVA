package semester1.practice06;

public class Ex38 {
  static class Vector3D {
    private double[] coords = new double[3];

    public void setCoords(double x, double y, double z) {
      coords[0] = x;
      coords[1] = y;
      coords[2] = z;
    }

    public double getMagnitude() {
      double sum = 0;
      for (double v : coords) sum += v * v;
      return Math.sqrt(sum);
    }

    public void multiplyByScalar(double scalar) {
      for (int i = 0; i < 3; i++) coords[i] *= scalar;
    }

    public void printVector() {
      System.out.printf("(%.2f; %.2f; %.2f)%n", coords[0], coords[1], coords[2]);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Vector3D v = new Vector3D();
    v.setCoords(2, 3, 6);
    System.out.println(v.getMagnitude());
    v.multiplyByScalar(2);
    v.printVector();
  }
}
