package semester1.practice07;

public class Ex10 {
  static class Fraction {
    private int numerator, denominator;

    public Fraction(int numerator, int denominator) {
      if (denominator == 0) {
        System.out.println("Знаменник не може бути нульовим");
        denominator = 1;
      }
      if (denominator < 0) {
        numerator = -numerator;
        denominator = -denominator;
      }
      int a = Math.abs(numerator), b = denominator;
      while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
      }
      this.numerator = numerator / a;
      this.denominator = denominator / a;
    }

    public Fraction(int wholeNumber) {
      this(wholeNumber, 1);
    }

    public Fraction() {
      this(0, 1);
    }

    public void print() {
      System.out.println(denominator == 1 ? "" + numerator : numerator + "/" + denominator);
    }

    public double toDouble() {
      return (double) numerator / denominator;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (Fraction f :
        new Fraction[] {new Fraction(), new Fraction(3), new Fraction(6, -8), new Fraction(4, 0)}) {
      f.print();
      System.out.println(f.toDouble());
    }
  }
}
