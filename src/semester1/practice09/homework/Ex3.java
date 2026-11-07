package semester1.practice09.homework;

import java.util.Arrays;

public final class Ex3 {
  private Ex3() {}

  private abstract static class Function1D {
    abstract double evaluate(double x);

    abstract double analyticDerivative(double x);

    abstract String name();

    final double numericalDerivative(double x) {
      double h = 1e-5;
      return (evaluate(x + h) - evaluate(x - h)) / (2 * h);
    }

    final double getDerivativeError(double x) {
      return Math.abs(analyticDerivative(x) - numericalDerivative(x));
    }

    final double integrateTrapezoidal(double a, double b, int intervals) {
      int n = intervals > 0 ? intervals : 1000;
      double step = (b - a) / n;
      double sum = (evaluate(a) + evaluate(b)) / 2;
      for (int i = 1; i < n; i++) sum += evaluate(a + i * step);
      return sum * step;
    }
  }

  private static final class PolynomialFunction extends Function1D {
    private final double[] coeffs;

    PolynomialFunction(double... coeffs) {
      this.coeffs = coeffs.clone();
    }

    @Override
    double evaluate(double x) {
      double result = 0;
      for (int i = coeffs.length - 1; i >= 0; i--) result = result * x + coeffs[i];
      return result;
    }

    @Override
    double analyticDerivative(double x) {
      double result = 0;
      for (int i = coeffs.length - 1; i >= 1; i--) result = result * x + i * coeffs[i];
      return result;
    }

    double[] getCoefficients() {
      return coeffs.clone();
    }

    @Override
    String name() {
      return "polynomial";
    }
  }

  private static final class SineWaveFunction extends Function1D {
    private final double amplitude, omega, phase;

    SineWaveFunction(double amplitude, double omega, double phase) {
      this.amplitude = amplitude;
      this.omega = omega;
      this.phase = phase;
    }

    @Override
    double evaluate(double x) {
      return amplitude * Math.sin(omega * x + phase);
    }

    @Override
    double analyticDerivative(double x) {
      return amplitude * omega * Math.cos(omega * x + phase);
    }

    @Override
    String name() {
      return "sine";
    }
  }

  private static final class CompositeFunction1D extends Function1D {
    private final Function1D outer, inner;

    CompositeFunction1D(Function1D outer, Function1D inner) {
      this.outer = outer;
      this.inner = inner;
    }

    @Override
    double evaluate(double x) {
      return outer.evaluate(inner.evaluate(x));
    }

    @Override
    double analyticDerivative(double x) {
      return outer.analyticDerivative(inner.evaluate(x)) * inner.analyticDerivative(x);
    }

    @Override
    String name() {
      return outer.name() + "(" + inner.name() + ")";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    PolynomialFunction g = new PolynomialFunction(1, 0, 1);
    SineWaveFunction f = new SineWaveFunction(2, 1, 0);
    CompositeFunction1D h = new CompositeFunction1D(f, g);
    double x = 1.5;
    double[] copy = g.getCoefficients();
    copy[0] = 999;
    System.out.printf(
        "g(2)=%.2f; integral[0,3]=%.4f%n", g.evaluate(2), g.integrateTrapezoidal(0, 3, 1000));
    System.out.printf("H(x)=2sin(x^2+1), H(%.2f)=%.6f%n", x, h.evaluate(x));
    System.out.printf(
        "H' analytic=%.6f; numeric=%.6f; error=%.2e%n",
        h.analyticDerivative(x), h.numericalDerivative(x), h.getDerivativeError(x));
    System.out.println("Defensive coeff copy: " + Arrays.toString(g.getCoefficients()));
  }
}
