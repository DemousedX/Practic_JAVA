package semester1.practice10;

public class Ex2 {

  abstract static class Shape2D {
    public abstract double getArea();

    public abstract double getPerimeter();
  }

  static class CircleShape extends Shape2D {
    private final double radius;

    CircleShape(double radius) {
      if (radius <= 0) throw new IllegalArgumentException("Радіус має бути додатним");
      this.radius = radius;
    }

    @Override
    public double getArea() {
      return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
      return 2 * Math.PI * radius;
    }

    public double getDiameter() {
      return 2 * radius;
    }
  }

  static class RectangleShape extends Shape2D {
    private final double a, b;

    RectangleShape(double a, double b) {
      if (a <= 0 || b <= 0) throw new IllegalArgumentException("Сторони мають бути додатними");
      this.a = a;
      this.b = b;
    }

    @Override
    public double getArea() {
      return a * b;
    }

    @Override
    public double getPerimeter() {
      return 2 * (a + b);
    }

    public double getDiagonal() {
      return Math.hypot(a, b);
    }

    public boolean isSquare() {
      return Math.abs(a - b) < 1e-9;
    }
  }

  static class EquilateralTriangleShape extends Shape2D {
    private final double a;

    EquilateralTriangleShape(double a) {
      if (a <= 0) throw new IllegalArgumentException("Сторона має бути додатною");
      this.a = a;
    }

    @Override
    public double getArea() {
      return Math.sqrt(3) * a * a / 4;
    }

    @Override
    public double getPerimeter() {
      return 3 * a;
    }
  }

  public static Shape2D findMaxAreaShape(Shape2D[] shapes) {
    Shape2D best = null;
    for (Shape2D s : shapes) if (best == null || s.getArea() > best.getArea()) best = s;
    return best;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    Shape2D[] shapes = {
      new CircleShape(5), new RectangleShape(4, 6), new EquilateralTriangleShape(8)
    };
    for (Shape2D s : shapes)
      System.out.printf(
          "%s: S=%.4f, P=%.4f%n", s.getClass().getSimpleName(), s.getArea(), s.getPerimeter());
    System.out.println("Найбільша площа: " + findMaxAreaShape(shapes).getClass().getSimpleName());
  }
}
