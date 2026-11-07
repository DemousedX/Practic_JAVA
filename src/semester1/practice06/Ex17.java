package semester1.practice06;

public class Ex17 {
  static class SimpleCalculator {
    public int add(int a, int b) {
      return a + b;
    }

    public int subtract(int a, int b) {
      return a - b;
    }

    public int multiply(int a, int b) {
      return a * b;
    }

    public double divide(int a, int b) {
      if (b == 0) {
        System.out.println("Ділення на нуль");
        return 0;
      }
      return (double) a / b;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    SimpleCalculator c = new SimpleCalculator();
    int sum = c.add(7, 2), difference = c.subtract(7, 2), product = c.multiply(7, 2);
    double quotient = c.divide(7, 2);
    System.out.println(sum + " " + difference + " " + product + " " + quotient);
    System.out.println(c.divide(7, 0));
  }
}
