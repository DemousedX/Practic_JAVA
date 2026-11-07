package semester1.practice07;

public class Ex4 {
  static class Point2D {
    private double x, y;

    public Point2D() {
      this(0, 0);
    }

    public Point2D(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public double distanceToOrigin() {
      return Math.hypot(x, y);
    }

    public double distanceTo(double targetX, double targetY) {
      return Math.hypot(x - targetX, y - targetY);
    }

    public void printPoint() {
      System.out.printf("Point(%.2f; %.2f)%n", x, y);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Point2D a = new Point2D(), b = new Point2D(3, 4);
    a.printPoint();
    b.printPoint();
    System.out.println(b.distanceToOrigin());
    System.out.println(a.distanceTo(3, 4));
  }
}
