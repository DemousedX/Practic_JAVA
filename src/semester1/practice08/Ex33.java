package semester1.practice08;

public class Ex33 {
  static class Progression {
    protected double firstTerm, step;

    public Progression(double firstTerm, double step) {
      this.firstTerm = firstTerm;
      this.step = step;
    }

    public double getTerm(int index) {
      return firstTerm;
    }

    public double[] generateFirstN(int n) {
      if (n < 0) throw new IllegalArgumentException("Кількість має бути невід'ємною");
      double[] a = new double[n];
      for (int i = 0; i < n; i++) a[i] = getTerm(i + 1);
      return a;
    }

    public String toString() {
      return java.util.Arrays.toString(generateFirstN(5));
    }
  }

  static class ArithmeticProgression extends Progression {
    public ArithmeticProgression(double firstTerm, double step) {
      super(firstTerm, step);
    }

    @Override
    public double getTerm(int n) {
      if (n < 1) throw new IllegalArgumentException("Індекс від 1");
      return firstTerm + (n - 1) * step;
    }

    @Override
    public String toString() {
      return "a(n)=" + firstTerm + "+(n-1)*" + step + " | " + super.toString();
    }
  }

  static class GeometricProgression extends Progression {
    public GeometricProgression(double firstTerm, double step) {
      super(firstTerm, step);
    }

    @Override
    public double getTerm(int n) {
      if (n < 1) throw new IllegalArgumentException("Індекс від 1");
      return firstTerm * Math.pow(step, n - 1);
    }

    @Override
    public String toString() {
      return "b(n)=" + firstTerm + "*" + step + "^(n-1) | " + super.toString();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new ArithmeticProgression(2, 3));
    System.out.println(new GeometricProgression(2, 2));
  }
}
