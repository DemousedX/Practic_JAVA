package semester1.practice07;

public class Ex17 {
  static class MathOperations {
    public int add(int a, int b) {
      return a + b;
    }

    public double add(double a, double b) {
      return a + b;
    }

    public int add(int a, int b, int c) {
      return a + b + c;
    }

    public String add(String a, String b) {
      return a + " " + b;
    }

    public int multiply(int a, int b) {
      return a * b;
    }

    public double multiply(double a, double b) {
      return a * b;
    }

    public String multiply(String text, int times) {
      return text.repeat(Math.max(0, times));
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    MathOperations m = new MathOperations();
    System.out.println(m.add(2, 3));
    System.out.println(m.add(2.5, 3.5));
    System.out.println(m.add(1, 2, 3));
    System.out.println(m.add("Привіт", "Java"));
    System.out.println(m.multiply(3, 4));
    System.out.println(m.multiply(2.5, 4.0));
    System.out.println(m.multiply("Java ", 3));
  }
}
