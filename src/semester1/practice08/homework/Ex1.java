package semester1.practice08.homework;

public final class Ex1 {
  private Ex1() {}

  private static class Circle {
    private double radius;

    Circle(double radius) {
      setRadius(radius);
    }

    double getRadius() {
      return radius;
    }

    void setRadius(double radius) {
      this.radius = radius > 0 ? radius : 1;
    }

    double getArea() {
      return Math.PI * radius * radius;
    }

    double getCircumference() {
      return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
      return String.format("Circle[r=%.2f, S=%.2f, C=%.2f]", radius, getArea(), getCircumference());
    }
  }

  private static final class Cylinder extends Circle {
    private final double height;

    Cylinder(double radius, double height) {
      super(radius);
      this.height = height > 0 ? height : 1;
    }

    double getVolume() {
      return super.getArea() * height;
    }

    double getTotalSurfaceArea() {
      return 2 * super.getArea() + super.getCircumference() * height;
    }

    @Override
    public String toString() {
      return String.format(
          "Cylinder[base=%s, h=%.2f, V=%.2f, TotalArea=%.2f]",
          super.toString(), height, getVolume(), getTotalSurfaceArea());
    }
  }

  private static final class Cone extends Circle {
    private final double height;

    Cone(double radius, double height) {
      super(radius);
      this.height = height > 0 ? height : 1;
    }

    double getSlantHeight() {
      return Math.hypot(getRadius(), height);
    }

    double getVolume() {
      return super.getArea() * height / 3.0;
    }

    double getTotalSurfaceArea() {
      return super.getArea() + Math.PI * getRadius() * getSlantHeight();
    }

    @Override
    public String toString() {
      return String.format(
          "Cone[base=%s, h=%.2f, l=%.2f, V=%.2f, TotalArea=%.2f]",
          super.toString(), height, getSlantHeight(), getVolume(), getTotalSurfaceArea());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println("================ ГЕОМЕТРІЯ ТІЛ ОБЕРТАННЯ ================");
    System.out.println(new Circle(5));
    System.out.println(new Cylinder(5, 10));
    System.out.println(new Cone(3, 4));
  }
}
