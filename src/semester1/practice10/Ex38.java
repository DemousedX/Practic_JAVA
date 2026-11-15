package semester1.practice10;

public class Ex38 {

  interface Integrable1D {
    double evaluate(double x);

    default double integrateTrapezoid(double a, double b, int n) {
      if (n <= 0) throw new IllegalArgumentException("n має бути додатним");
      double h = (b - a) / n, sum = (evaluate(a) + evaluate(b)) / 2;
      for (int i = 1; i < n; i++) sum += evaluate(a + i * h);
      return sum * h;
    }
  }

  interface RootFindable {
    double findRootBisection(double left, double right, double eps);
  }

  abstract static class AbstractAnalyticFunction implements Integrable1D {}

  static class CubicFunction extends AbstractAnalyticFunction implements RootFindable {
    @Override
    public double evaluate(double x) {
      return x * x * x - 2 * x - 5;
    }

    @Override
    public double findRootBisection(double left, double right, double eps) {
      if (!Double.isFinite(left)
          || !Double.isFinite(right)
          || left > right
          || !Double.isFinite(eps)
          || eps <= 0) throw new IllegalArgumentException("Некоректний інтервал або точність");
      double fl = evaluate(left), fr = evaluate(right);
      if (fl == 0) return left;
      if (fr == 0) return right;
      if (Math.signum(fl) == Math.signum(fr))
        throw new IllegalArgumentException("Корінь не відокремлено");
      for (int i = 0; i < 1000; i++) {
        double mid = left + (right - left) / 2, fm = evaluate(mid);
        if (fm == 0 || (right - left) / 2 <= eps) return mid;
        if (Math.signum(fm) == Math.signum(fl)) {
          left = mid;
          fl = fm;
        } else right = mid;
      }
      throw new IllegalStateException("Не досягнуто точності");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    CubicFunction f = new CubicFunction();
    System.out.printf("Інтеграл [0; 3]: %.6f%n", f.integrateTrapezoid(0, 3, 10000));
    double root = f.findRootBisection(2, 3, 1e-6);
    System.out.printf("Корінь: %.7f, f(x)=%.3e%n", root, f.evaluate(root));
  }
}
