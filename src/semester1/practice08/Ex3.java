package semester1.practice08;

public final class Ex3 {
  private Ex3() {}

  static class Circle {
    private double radius;

    Circle(double radius) {
      setRadius(radius);
    }

    public double getRadius() {
      return radius;
    }

    public void setRadius(double value) {
      radius = value > 0 ? value : 1;
    }

    public double getArea() {
      return Math.PI * radius * radius;
    }

    public double getCircumference() {
      return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
      return String.format(
          "Circle{radius=%.2f, area=%.2f, circumference=%.2f}",
          radius, getArea(), getCircumference());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 03 ---%n");

    Circle circle = new Circle(-4);
    System.out.println(circle);
    circle.setRadius(-5);
    System.out.println(circle);
    circle.setRadius(5);
    System.out.println(circle);
  }
}
