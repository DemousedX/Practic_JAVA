package semester1.practice09;

public class Ex7 {
  static class EncapsulatedPolynomial {
    private final double[] coeffs;

    public EncapsulatedPolynomial(double[] coeffs) {
      this.coeffs = coeffs == null ? new double[0] : coeffs.clone();
    }

    public int getDegree() {
      int i = coeffs.length - 1;
      while (i > 0 && coeffs[i] == 0) i--;
      return Math.max(0, i);
    }

    public double getCoefficient(int power) {
      if (power < 0 || power >= coeffs.length)
        throw new IndexOutOfBoundsException("Степінь поза діапазоном");
      return coeffs[power];
    }

    public double evaluate(double x) {
      double result = 0;
      for (int i = coeffs.length - 1; i >= 0; i--) result = result * x + coeffs[i];
      return result;
    }

    public String toString() {
      StringBuilder text = new StringBuilder();
      for (int i = coeffs.length - 1; i >= 0; i--) {
        double c = coeffs[i];
        if (c == 0) continue;
        if (text.length() > 0) text.append(c < 0 ? " - " : " + ");
        else if (c < 0) text.append("-");
        text.append(Math.abs(c));
        if (i > 0) text.append("*x");
        if (i > 1) text.append("^").append(i);
      }
      return text.length() == 0 ? "0" : text.toString();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    double[] c = {2, -3, 1};
    EncapsulatedPolynomial p = new EncapsulatedPolynomial(c);
    c[0] = 99;
    System.out.println(
        p
            + " | P(4)="
            + p.evaluate(4)
            + " | degree="
            + p.getDegree()
            + " | c1="
            + p.getCoefficient(1));
  }
}
