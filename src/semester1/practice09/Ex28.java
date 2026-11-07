package semester1.practice09;

public final class Ex28 {
  private Ex28() {}

  abstract static class AbstractSequence {
    private final String title;

    AbstractSequence(String t) {
      title = t;
    }

    public abstract double getTerm(int n);

    public double sumFirstN(int n) {
      double s = 0;
      for (int i = 1; i <= n; i++) s += getTerm(i);
      return s;
    }

    public String toString() {
      return title + " sum=" + sumFirstN(5);
    }
  }

  static final class HarmonicSequence extends AbstractSequence {
    HarmonicSequence() {
      super("HarmonicSequence");
    }

    public double getTerm(int n) {
      if (n < 1) throw new IllegalArgumentException("Індекс від 1");
      return 1.0 / n;
    }
  }

  static final class SquareNumbersSequence extends AbstractSequence {
    SquareNumbersSequence() {
      super("SquareNumbersSequence");
    }

    public double getTerm(int n) {
      if (n < 1) throw new IllegalArgumentException("Індекс від 1");
      return (double) n * n;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new HarmonicSequence());
    System.out.println(new SquareNumbersSequence());
  }
}
