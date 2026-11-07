package semester1.practice09;

public class Ex9 {
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

    public void set(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public double distanceTo(Point2D other) {
      return Math.hypot(x - other.x, y - other.y);
    }

    public String toString() {
      return "(" + x + "; " + y + ")";
    }
  }

  static class CompositeCircle {
    private double radius;
    private final Point2D center;

    public CompositeCircle(double centerX, double centerY, double radius) {
      center = new Point2D(centerX, centerY);
      this.radius = Math.max(0, radius);
    }

    public boolean containsPoint(Point2D p) {
      return p != null && center.distanceTo(p) <= radius;
    }

    public String toString() {
      return "Circle{center=" + center + ", radius=" + radius + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    CompositeCircle c = new CompositeCircle(2, 3, 5);
    System.out.println(c);
    System.out.println(c.containsPoint(new Point2D(4, 4)));
    System.out.println(c.containsPoint(new Point2D(20, 20)));
  }
}
