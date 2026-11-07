package semester1.practice07;

public class Ex27 {
  static class MathUtils {
    private MathUtils() {}

    public static final double PI = 3.1415926535, E = 2.7182818284;

    public static long factorial(int n) {
      if (n < 0 || n > 20) throw new IllegalArgumentException("Потрібне число від 0 до 20");
      long result = 1;
      for (int i = 2; i <= n; i++) result *= i;
      return result;
    }

    public static double power(double base, int exp) {
      double result = 1;
      long n = exp;
      if (n < 0) {
        base = 1 / base;
        n = -n;
      }
      while (n > 0) {
        if (n % 2 == 1) result *= base;
        base *= base;
        n /= 2;
      }
      return result;
    }

    public static int gcd(int a, int b) {
      a = Math.abs(a);
      b = Math.abs(b);
      while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
      }
      return a;
    }

    public static int clamp(int val, int min, int max) {
      if (min > max) throw new IllegalArgumentException("Хибний діапазон");
      return Math.max(min, Math.min(max, val));
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(MathUtils.factorial(5));
    System.out.println(MathUtils.power(2, -3));
    System.out.println(MathUtils.gcd(24, 18));
    System.out.println(MathUtils.clamp(120, 0, 100));
    System.out.println(MathUtils.PI + " " + MathUtils.E);
  }
}
