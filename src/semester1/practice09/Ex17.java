package semester1.practice09;

public class Ex17 {
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

  static class Polyline {
    private final Point2D[] vertices;
    private int count;

    public Polyline(int capacity) {
      vertices = new Point2D[capacity];
    }

    public void addVertex(double x, double y) {
      if (count >= vertices.length) throw new IllegalStateException("Масив заповнено");
      vertices[count++] = new Point2D(x, y);
    }

    public double getTotalLength() {
      double sum = 0;
      for (int i = 1; i < count; i++) sum += vertices[i - 1].distanceTo(vertices[i]);
      return sum;
    }

    public double getClosedPerimeter() {
      return count < 2 ? 0 : getTotalLength() + vertices[count - 1].distanceTo(vertices[0]);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Polyline p = new Polyline(3);
    p.addVertex(0, 0);
    p.addVertex(3, 0);
    p.addVertex(3, 4);
    System.out.println("Довжина: " + p.getTotalLength());
    System.out.println("Периметр: " + p.getClosedPerimeter());
  }
}
