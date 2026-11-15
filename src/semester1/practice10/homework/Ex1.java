package semester1.practice10.homework;

public class Ex1 {

  interface Scalable2D {
    double MIN_SCALE_FACTOR = 0.1;

    void scale(double factor);
  }

  interface Rotatable2D {
    void rotate(double deltaDegrees);

    double getRotationAngle();
  }

  static double positive(double value) {
    if (!Double.isFinite(value) || value <= 0)
      throw new IllegalArgumentException("Розмір має бути додатним");
    return value;
  }

  static double scaleFactor(double factor) {
    if (!Double.isFinite(factor)) throw new IllegalArgumentException("Некоректний масштаб");
    return Math.max(Scalable2D.MIN_SCALE_FACTOR, factor);
  }

  abstract static class AbstractShape2D {
    private final String name;
    private double centerX, centerY;

    AbstractShape2D(String name, double x, double y) {
      this.name = name;
      centerX = x;
      centerY = y;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public final double getIsoperimetricQuotient() {
      double p = getPerimeter();
      return 4 * Math.PI * getArea() / (p * p);
    }

    protected String dimensions() {
      return "";
    }

    @Override
    public String toString() {
      return String.format(
          "%s '%s', центр=(%.1f; %.1f), %s | S=%.4f, P=%.4f, Q=%.4f",
          getClass().getSimpleName(),
          name,
          centerX,
          centerY,
          dimensions(),
          getArea(),
          getPerimeter(),
          getIsoperimetricQuotient());
    }
  }

  static class CircleShape extends AbstractShape2D implements Scalable2D {
    private double radius;

    CircleShape(String name, double x, double y, double radius) {
      super(name, x, y);
      this.radius = positive(radius);
    }

    @Override
    public double getArea() {
      return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
      return 2 * Math.PI * radius;
    }

    @Override
    public void scale(double factor) {
      radius *= scaleFactor(factor);
    }

    @Override
    protected String dimensions() {
      return String.format("r=%.2f", radius);
    }
  }

  static class RectangleShape extends AbstractShape2D implements Scalable2D, Rotatable2D {
    private double width, height, rotationAngle;

    RectangleShape(String name, double x, double y, double width, double height) {
      super(name, x, y);
      this.width = positive(width);
      this.height = positive(height);
    }

    @Override
    public double getArea() {
      return width * height;
    }

    @Override
    public double getPerimeter() {
      return 2 * (width + height);
    }

    @Override
    public void scale(double factor) {
      double f = scaleFactor(factor);
      width *= f;
      height *= f;
    }

    @Override
    public void rotate(double deltaDegrees) {
      if (!Double.isFinite(deltaDegrees)) throw new IllegalArgumentException("Некоректний кут");
      rotationAngle = ((rotationAngle + deltaDegrees) % 360 + 360) % 360;
    }

    @Override
    public double getRotationAngle() {
      return rotationAngle;
    }

    @Override
    protected String dimensions() {
      return String.format("%.2fx%.2f, кут=%.1f", width, height, rotationAngle);
    }
  }

  static class RightTriangleShape extends AbstractShape2D implements Scalable2D, Rotatable2D {
    private double a, b, rotationAngle;

    RightTriangleShape(String name, double x, double y, double a, double b) {
      super(name, x, y);
      this.a = positive(a);
      this.b = positive(b);
    }

    @Override
    public double getArea() {
      return a * b / 2;
    }

    @Override
    public double getPerimeter() {
      return a + b + Math.hypot(a, b);
    }

    @Override
    public void scale(double factor) {
      double f = scaleFactor(factor);
      a *= f;
      b *= f;
    }

    @Override
    public void rotate(double deltaDegrees) {
      if (!Double.isFinite(deltaDegrees)) throw new IllegalArgumentException("Некоректний кут");
      rotationAngle = ((rotationAngle + deltaDegrees) % 360 + 360) % 360;
    }

    @Override
    public double getRotationAngle() {
      return rotationAngle;
    }

    @Override
    protected String dimensions() {
      return String.format("катети %.2f, %.2f, кут=%.1f", a, b, rotationAngle);
    }
  }

  public static final class ImmutableReferenceSquare extends AbstractShape2D {
    private final double side;

    ImmutableReferenceSquare(String name, double x, double y, double side) {
      super(name, x, y);
      this.side = positive(side);
    }

    @Override
    public double getArea() {
      return side * side;
    }

    @Override
    public double getPerimeter() {
      return 4 * side;
    }

    @Override
    protected String dimensions() {
      return "сторона=" + side;
    }
  }

  public static double calculateTotalArea(AbstractShape2D[] shapes) {
    double total = 0;
    for (AbstractShape2D s : shapes) total += s.getArea();
    return total;
  }

  public static void transformScene(
      AbstractShape2D[] shapes, double scaleFactor, double rotateDeg) {
    for (AbstractShape2D shape : shapes) {
      if (shape instanceof Scalable2D s) s.scale(scaleFactor);
      if (shape instanceof Rotatable2D r) r.rotate(rotateDeg);
    }
  }

  static void printScene(AbstractShape2D[] shapes) {
    for (AbstractShape2D s : shapes) System.out.println(s);
    System.out.printf("Сумарна площа: %.4f%n", calculateTotalArea(shapes));
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    AbstractShape2D[] shapes = {
      new CircleShape("Коло", 0, 0, 5),
      new RectangleShape("Рамка", 2, 3, 4, 6),
      new ImmutableReferenceSquare("Еталон", 10, 10, 5)
    };
    System.out.println("До трансформації:");
    printScene(shapes);
    transformScene(shapes, 2, 45);
    System.out.println("Після масштабу x2 та повороту на 45 градусів:");
    printScene(shapes);
    AbstractShape2D[] triangles = {new RightTriangleShape("Трикутник", 0, 0, 3, 4)};
    transformScene(triangles, 2, 45);
    printScene(triangles);
  }
}
