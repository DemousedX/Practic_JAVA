package semester1.practice07;

public class Ex19 {
  static class AreaCalculator {
    public double calculateArea(double side) {
      return side * side;
    }

    public double calculateArea(double width, double height) {
      return width * height;
    }

    public double calculateArea(double radius, boolean isCircle) {
      return isCircle ? Math.PI * radius * radius : calculateArea(radius);
    }

    public double calculateArea(double a, double b, double c) {
      if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) return 0;
      double p = (a + b + c) / 2;
      return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double calculateTrapezoidArea(double base1, double base2, double height) {
      return (base1 + base2) * height / 2;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    AreaCalculator a = new AreaCalculator();
    System.out.println(a.calculateArea(3));
    System.out.println(a.calculateArea(2, 4));
    System.out.println(a.calculateArea(3, true));
    System.out.println(a.calculateArea(3, 4, 5));
    System.out.println(a.calculateTrapezoidArea(3, 5, 4));
  }
}
