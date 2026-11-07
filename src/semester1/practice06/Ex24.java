package semester1.practice06;

public class Ex24 {
  static class Triangle {
    double a, b, c;

    public boolean isValid() {
      return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }

    public double getPerimeter() {
      return a + b + c;
    }

    public double getArea() {
      if (!isValid()) return 0;
      double p = getPerimeter() / 2;
      return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Triangle t = new Triangle();
    t.a = 3;
    t.b = 4;
    t.c = 5;
    System.out.println(t.isValid());
    System.out.println(t.getPerimeter());
    System.out.println(t.getArea());
  }
}
