package semester1.practice04;

public class Ex35 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println("Дробовий лічильник");
    for (double d = 0.0; d <= 1.0; d += 0.1) {
      System.out.println(d);
    }
    System.out.println("Цілий лічильник");
    for (int i = 0; i <= 10; i++) {
      double val = i / 10.0;
      System.out.println(val);
    }
  }
}
