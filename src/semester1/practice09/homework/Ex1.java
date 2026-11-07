package semester1.practice09.homework;

public final class Ex1 {
  private static final class Point2D {
    private double x, y;

    Point2D(double x, double y) {
      this.x = x;
      this.y = y;
    }

    Point2D(Point2D other) {
      this(other.x, other.y);
    }

    void translate(double dx, double dy) {
      x += dx;
      y += dy;
    }

    double distanceTo(Point2D other) {
      return Math.hypot(x - other.x, y - other.y);
    }

    @Override
    public String toString() {
      return String.format("(%.2f, %.2f)", x, y);
    }
  }

  private abstract static class AbstractShape2D {
    private final String name;
    private final Point2D anchorPoint;

    AbstractShape2D(String name, Point2D point) {
      this.name = name;
      anchorPoint = new Point2D(point);
    }

    Point2D getAnchorPoint() {
      return new Point2D(anchorPoint);
    }

    void moveBy(double dx, double dy) {
      anchorPoint.translate(dx, dy);
    }

    abstract double getArea();

    abstract double getPerimeter();

    @Override
    public String toString() {
      return String.format(
          "%s at %s, area=%.2f, perimeter=%.2f", name, anchorPoint, getArea(), getPerimeter());
    }
  }

  private static final class Circle2D extends AbstractShape2D {
    private final double radius;

    Circle2D(String name, Point2D point, double radius) {
      super(name, point);
      this.radius = Math.max(0, radius);
    }

    @Override
    double getArea() {
      return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
      return 2 * Math.PI * radius;
    }
  }

  private static final class Rectangle2D extends AbstractShape2D {
    private final double width, height;

    Rectangle2D(String name, Point2D point, double width, double height) {
      super(name, point);
      this.width = Math.max(0, width);
      this.height = Math.max(0, height);
    }

    @Override
    double getArea() {
      return width * height;
    }

    @Override
    double getPerimeter() {
      return 2 * (width + height);
    }
  }

  private static final class RightTriangle2D extends AbstractShape2D {
    private final double a, b;

    RightTriangle2D(String name, Point2D point, double a, double b) {
      super(name, point);
      this.a = Math.max(0, a);
      this.b = Math.max(0, b);
    }

    @Override
    double getArea() {
      return a * b / 2;
    }

    @Override
    double getPerimeter() {
      return a + b + Math.hypot(a, b);
    }
  }

  private static final class GeometryCanvas {
    private final AbstractShape2D[] shapes;
    private int size;

    GeometryCanvas(int capacity) {
      shapes = new AbstractShape2D[capacity];
    }

    boolean add(AbstractShape2D shape) {
      if (shape == null || size == shapes.length) return false;
      shapes[size++] = shape;
      return true;
    }

    void print() {
      for (int i = 0; i < size; i++) System.out.println(shapes[i]);
    }
  }

  private void runTask() {
    GeometryCanvas canvas = new GeometryCanvas(5);
    canvas.add(new Circle2D("Circle", new Point2D(2, 3), 4));
    canvas.add(new Rectangle2D("Rectangle", new Point2D(-1, 2), 5, 3));
    canvas.add(new RightTriangle2D("Triangle", new Point2D(0, 0), 3, 4));
    canvas.print();
    Point2D point = new Point2D(1, 2);
    AbstractShape2D shape = new Circle2D("Movable", point, 2);
    point.translate(100, 100);
    shape.moveBy(1, -1);
    System.out.println(shape);
    System.out.println("Copied anchor: " + shape.getAnchorPoint());
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new Ex1().runTask();
  }
}
