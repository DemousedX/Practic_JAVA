package semester1.practice06;

public class Ex20 {
  static class NumberChecker {
    public boolean isEven(int n) {
      return n % 2 == 0;
    }

    public boolean isPositive(int n) {
      return n > 0;
    }

    public boolean isPrime(int n) {
      if (n < 2) return false;
      for (int i = 2; i <= n / i; i++) if (n % i == 0) return false;
      return true;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    NumberChecker c = new NumberChecker();
    for (int n : new int[] {7, 12, -5})
      System.out.println(
          n
              + " | парне "
              + c.isEven(n)
              + " | додатне "
              + c.isPositive(n)
              + " | просте "
              + c.isPrime(n));
  }
}
