package semester1.practice09;

public class Ex24 {
  static class LinearEquation {
    private final double a, b, c;

    public LinearEquation(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public boolean isSatisfiedBy(double x, double y) {
      return Math.abs(a * x + b * y - c) <= 1e-6;
    }
  }

  static class EquationSystem {
    private final LinearEquation[] equations;
    private int count;

    public EquationSystem(int capacity) {
      equations = new LinearEquation[capacity];
    }

    public void addEquation(LinearEquation e) {
      if (e != null && count < equations.length) equations[count++] = e;
    }

    public boolean checkSolution(double x, double y) {
      for (int i = 0; i < count; i++) if (!equations[i].isSatisfiedBy(x, y)) return false;
      return true;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    EquationSystem s = new EquationSystem(3);
    s.addEquation(new LinearEquation(2, 3, 8));
    s.addEquation(new LinearEquation(4, -1, 2));
    System.out.println(s.checkSolution(1, 2));
    System.out.println(s.checkSolution(2, 1));
  }
}
