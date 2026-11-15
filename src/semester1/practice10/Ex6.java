package semester1.practice10;

public class Ex6 {

  abstract static class DifferentiableFunction {
    public abstract double f(double x);

    public double derivativeAt(double x) {
      double h = 1e-5;
      return (f(x + h) - f(x - h)) / (2 * h);
    }
  }

  static class QuadraticParabola extends DifferentiableFunction {
    private final double a, b, c;

    QuadraticParabola(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    @Override
    public double f(double x) {
      return a * x * x + b * x + c;
    }
  }

  static class NaturalLogFunction extends DifferentiableFunction {
    private final double k;

    NaturalLogFunction(double k) {
      this.k = k;
    }

    @Override
    public double f(double x) {
      if (x <= 0) throw new IllegalArgumentException("Потрібно x > 0");
      return k * Math.log(x);
    }
  }

  static class ExponentialGrowth extends DifferentiableFunction {
    private final double amplitude, lambda;

    ExponentialGrowth(double amplitude, double lambda) {
      this.amplitude = amplitude;
      this.lambda = lambda;
    }

    @Override
    public double f(double x) {
      return amplitude * Math.exp(lambda * x);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    DifferentiableFunction[] functions = {
      new QuadraticParabola(1, -2, 3), new NaturalLogFunction(2), new ExponentialGrowth(3, 0.5)
    };
    for (DifferentiableFunction f : functions)
      System.out.printf(
          "%s: f(2)=%.6f, f'(2)=%.6f%n", f.getClass().getSimpleName(), f.f(2), f.derivativeAt(2));
  }
}
