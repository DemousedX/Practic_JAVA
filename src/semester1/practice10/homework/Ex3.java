package semester1.practice10.homework;

public class Ex3 {

  interface Evaluable1D {
    double EPSILON = 1e-7;

    double evaluate(double x);
  }

  interface Integrable1D extends Evaluable1D {
    default double integrateSimpson(double a, double b, int n) {
      if (n < 2) n = 100;
      if (n % 2 != 0) n++;
      double h = (b - a) / n, sum = evaluate(a) + evaluate(b);
      for (int i = 1; i < n; i++) sum += (i % 2 == 0 ? 2 : 4) * evaluate(a + i * h);
      return sum * h / 3;
    }
  }

  interface Differentiable1D extends Evaluable1D {
    double derivative(double x);

    default double numericalDerivative(double x) {
      double h = 1e-5;
      return (evaluate(x + h) - evaluate(x - h)) / (2 * h);
    }
  }

  interface NewtonRootFindable extends Differentiable1D {
    default double findRootNewton(double x0, int maxIter) {
      if (!Double.isFinite(x0) || maxIter <= 0)
        throw new IllegalArgumentException("Некоректні параметри пошуку");
      double x = x0;
      for (int i = 0; i < maxIter; i++) {
        double y = evaluate(x);
        if (!Double.isFinite(y)) throw new ArithmeticException("Некоректне значення функції");
        if (Math.abs(y) <= EPSILON) return x;
        double d = derivative(x);
        if (!Double.isFinite(d) || Math.abs(d) < 1e-12)
          throw new ArithmeticException("Похідна близька до нуля");
        x -= y / d;
        if (!Double.isFinite(x)) throw new ArithmeticException("Метод розбігається");
      }
      if (Math.abs(evaluate(x)) <= EPSILON) return x;
      throw new ArithmeticException("Не досягнуто збіжності");
    }
  }

  abstract static class AbstractMathFunction implements Integrable1D {
    private final String formulaTitle;

    AbstractMathFunction(String title) {
      formulaTitle = title;
    }

    public final String getFormulaTitle() {
      return formulaTitle;
    }
  }

  public static final class PolynomialFunction extends AbstractMathFunction
      implements NewtonRootFindable {
    private final double[] coeffs;

    PolynomialFunction(double[] coeffs) {
      super("P(x)=" + java.util.Arrays.toString(coeffs) + " (коефіцієнти від c0)");
      if (coeffs.length == 0) throw new IllegalArgumentException("Порожній поліном");
      this.coeffs = java.util.Arrays.copyOf(coeffs, coeffs.length);
    }

    public double[] getCoefficients() {
      return java.util.Arrays.copyOf(coeffs, coeffs.length);
    }

    @Override
    public double evaluate(double x) {
      double result = 0;
      for (int i = coeffs.length - 1; i >= 0; i--) result = result * x + coeffs[i];
      return result;
    }

    @Override
    public double derivative(double x) {
      double result = 0;
      for (int i = coeffs.length - 1; i >= 1; i--) result = result * x + i * coeffs[i];
      return result;
    }
  }

  static class DampedHarmonyFunction extends AbstractMathFunction implements NewtonRootFindable {
    private final double amplitude, decayRate, omega;

    DampedHarmonyFunction(double amplitude, double decayRate, double omega) {
      super("A*exp(-gamma*x)*cos(omega*x)");
      this.amplitude = amplitude;
      this.decayRate = decayRate;
      this.omega = omega;
    }

    @Override
    public double evaluate(double x) {
      return amplitude * Math.exp(-decayRate * x) * Math.cos(omega * x);
    }

    @Override
    public double derivative(double x) {
      return -amplitude
          * Math.exp(-decayRate * x)
          * (decayRate * Math.cos(omega * x) + omega * Math.sin(omega * x));
    }
  }

  static class StepHeavisideFunction extends AbstractMathFunction {
    private final double threshold, lowValue, highValue;

    StepHeavisideFunction(double threshold, double low, double high) {
      super("Сходинка: " + low + " при x < " + threshold + ", інакше " + high);
      this.threshold = threshold;
      lowValue = low;
      highValue = high;
    }

    @Override
    public double evaluate(double x) {
      return x < threshold ? lowValue : highValue;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    AbstractMathFunction[] functions = {
      new PolynomialFunction(new double[] {-5, -2, 0, 1}),
      new DampedHarmonyFunction(4, 0.5, 2),
      new StepHeavisideFunction(1.5, 2, 5)
    };
    for (AbstractMathFunction f : functions) {
      System.out.println(f.getFormulaTitle());
      System.out.printf("Інтеграл Сімпсона [0; 3]: %.6f%n", f.integrateSimpson(0, 3, 1000));
      if (f instanceof NewtonRootFindable rf) {
        double point = f instanceof PolynomialFunction ? 2 : 1;
        double guess = f instanceof PolynomialFunction ? 2 : 0.7;
        double root = rf.findRootNewton(guess, 100);
        System.out.printf(
            "Похідна: %.6f, чисельна: %.6f%nКорінь: %.7f, f(x)=%.3e%n",
            rf.derivative(point), rf.numericalDerivative(point), root, f.evaluate(root));
      } else
        System.out.println(
            "Пошук Ньютона пропущено; точний інтеграл сходинки: 10.5, чисельний має похибку біля"
                + " розриву");
    }
  }
}
