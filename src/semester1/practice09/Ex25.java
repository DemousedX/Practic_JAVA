package semester1.practice09;

public final class Ex25 {
  private Ex25() {}

  abstract static class AbstractShape {
    private final String color;

    AbstractShape(String c) {
      color = c == null ? "white" : c;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public double ratio() {
      return getPerimeter() > 0 ? getArea() / getPerimeter() : 0;
    }

    public String toString() {
      return String.format(
          "AbstractShape[color=%s, S=%.2f, P=%.2f]", color, getArea(), getPerimeter());
    }
  }

  static final class CircleShape extends AbstractShape {
    private final double r;

    CircleShape(String c, double r) {
      super(c);
      this.r = Math.max(0, r);
    }

    public double getArea() {
      return Math.PI * r * r;
    }

    public double getPerimeter() {
      return 2 * Math.PI * r;
    }
  }

  static final class RectangleShape extends AbstractShape {
    private final double w, h;

    RectangleShape(String c, double w, double h) {
      super(c);
      this.w = Math.max(0, w);
      this.h = Math.max(0, h);
    }

    public double getArea() {
      return w * h;
    }

    public double getPerimeter() {
      return 2 * (w + h);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new CircleShape("blue", 3));
    System.out.println(new RectangleShape("green", 4, 5));
  }
}
