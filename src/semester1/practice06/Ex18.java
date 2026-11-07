package semester1.practice06;

public class Ex18 {
  static class Circle {
    double radius;

    public double getArea() {
      return Math.PI * radius * radius;
    }

    public double getCircumference() {
      return 2 * Math.PI * radius;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Circle c = new Circle();
    c.radius = 5;
    System.out.println(c.getArea());
    System.out.println(c.getCircumference());
  }
}
