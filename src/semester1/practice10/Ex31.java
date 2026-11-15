package semester1.practice10;

public class Ex31 {

  static class Matrix2x2 {
    final double a11, a12, a21, a22;

    Matrix2x2(double a, double b, double c, double d) {
      a11 = a;
      a12 = b;
      a21 = c;
      a22 = d;
    }

    double determinant() {
      return a11 * a22 - a12 * a21;
    }

    @Override
    public String toString() {
      return String.format("[[%.4f, %.4f], [%.4f, %.4f]]", a11, a12, a21, a22);
    }
  }

  interface InvertibleMatrix {
    Matrix2x2 inverse();
  }

  interface OrthogonalMatrix {
    boolean checkOrthogonality();
  }

  static class RotationMatrix2x2 extends Matrix2x2 implements InvertibleMatrix, OrthogonalMatrix {
    RotationMatrix2x2(double angle) {
      super(Math.cos(angle), -Math.sin(angle), Math.sin(angle), Math.cos(angle));
    }

    @Override
    public Matrix2x2 inverse() {
      return new Matrix2x2(a11, a21, a12, a22);
    }

    @Override
    public boolean checkOrthogonality() {
      return Math.abs(a11 * a11 + a21 * a21 - 1) < 1e-9
          && Math.abs(a12 * a12 + a22 * a22 - 1) < 1e-9
          && Math.abs(a11 * a12 + a21 * a22) < 1e-9;
    }
  }

  static class SingularMatrix2x2 extends Matrix2x2 {
    SingularMatrix2x2() {
      super(1, 2, 2, 4);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    for (Matrix2x2 m :
        new Matrix2x2[] {new RotationMatrix2x2(Math.PI / 3), new SingularMatrix2x2()}) {
      System.out.println(m + ", det=" + m.determinant());
      if (m instanceof InvertibleMatrix inv) System.out.println("Обернена: " + inv.inverse());
      if (m instanceof OrthogonalMatrix ort)
        System.out.println("Ортогональна: " + ort.checkOrthogonality());
    }
  }
}
