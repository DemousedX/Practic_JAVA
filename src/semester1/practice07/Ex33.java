package semester1.practice07;

public class Ex33 {
  static class Point {
    private double x, y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public double getX() {
      return x;
    }

    public double getY() {
      return y;
    }
  }

  static class LineSegment {
    private Point start, end;

    public LineSegment(Point start, Point end) {
      this.start = start;
      this.end = end;
    }

    public LineSegment(double x1, double y1, double x2, double y2) {
      this(new Point(x1, y1), new Point(x2, y2));
    }

    public double getLength() {
      return Math.hypot(end.getX() - start.getX(), end.getY() - start.getY());
    }

    public Point getMidPoint() {
      return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    public void printSegment() {
      Point m = getMidPoint();
      System.out.printf(
          "(%.2f; %.2f) - (%.2f; %.2f) | довжина %.2f | середина (%.2f; %.2f)%n",
          start.getX(), start.getY(), end.getX(), end.getY(), getLength(), m.getX(), m.getY());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new LineSegment(0, 0, 3, 4).printSegment();
    new LineSegment(new Point(1, 1), new Point(5, 4)).printSegment();
  }
}
