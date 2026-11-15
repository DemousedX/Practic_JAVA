package semester1.practice10;

public class Ex3 {

  static class VectorMathOverload {
    double norm(double x) {
      return Math.abs(x);
    }

    double norm(double x, double y) {
      return Math.hypot(x, y);
    }

    double norm(double[] v) {
      double sum = 0;
      for (double x : v) sum += x * x;
      return Math.sqrt(sum);
    }
  }

  abstract static class BinaryOperation {
    public abstract double apply(double a, double b);
  }

  static class AddOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) {
      return a + b;
    }
  }

  static class MultiplyOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) {
      return a * b;
    }
  }

  static class HypotenuseOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) {
      return Math.hypot(a, b);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    VectorMathOverload math = new VectorMathOverload();
    System.out.println(
        "Норми: "
            + math.norm(-3)
            + "; "
            + math.norm(3, 4)
            + "; "
            + math.norm(new double[] {2, 3, 6}));
    BinaryOperation[] operations = {new AddOp(), new MultiplyOp(), new HypotenuseOp()};
    for (BinaryOperation op : operations)
      System.out.println(op.getClass().getSimpleName() + ": " + op.apply(3, 4));
  }
}
