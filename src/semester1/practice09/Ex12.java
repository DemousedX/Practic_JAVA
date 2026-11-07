package semester1.practice09;

public class Ex12 {
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

  static class LineSegment {
    private final Point2D start, end;

    public LineSegment(Point2D start, Point2D end) {
      this.start = new Point2D(start.getX(), start.getY());
      this.end = new Point2D(end.getX(), end.getY());
    }

    public double getLength() {
      return start.distanceTo(end);
    }

    public Point2D getMidpoint() {
      return new Point2D((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    public String toString() {
      return start + " - " + end + " | length=" + getLength() + " | midpoint=" + getMidpoint();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Point2D a = new Point2D(0, 0), b = new Point2D(3, 4);
    LineSegment s = new LineSegment(a, b);
    a.set(100, 100);
    s.getMidpoint().set(99, 99);
    System.out.println(s);
  }
}
