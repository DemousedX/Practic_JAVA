package semester1.practice08;

public final class Ex35 {
  private Ex35() {}

  static class LinearFunction {
    protected double k, b;

    LinearFunction(double k, double b) {
      this.k = k;
      this.b = b;
    }

    public double evaluate(double x) {
      return k * x + b;
    }

    @Override
    public String toString() {
      return "f(x) = " + k + "x + " + b;
    }
  }

  static class QuadraticFunction extends LinearFunction {
    private double a;

    QuadraticFunction(double a, double k, double b) {
      super(k, b);
      this.a = a;
    }

    @Override
    public double evaluate(double x) {
      return a * x * x + super.evaluate(x);
    }

    public double vertexX() {
      return a == 0 ? Double.NaN : -k / (2 * a);
    }

    @Override
    public String toString() {
      return "g(x) = " + a + "x^2 + " + k + "x + " + b + ", vertex x=" + vertexX();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 35 ---%n");

    QuadraticFunction function = new QuadraticFunction(2, -4, 1);
    System.out.println(function + ", g(3)=" + function.evaluate(3));
  }
}
