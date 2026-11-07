package semester1.practice03;

public class Ex15 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int x = 5, y = 20;
    if (x > 10)
      if (y > 10) System.out.println("Обидва числа більші за 10");
      else System.out.println("Внутрішній else");
    System.out.println("Без дужок else належить найближчому if(y > 10)");
    if (x > 10) {
      if (y > 10) {
        System.out.println("Обидва числа більші за 10");
      }
    } else {
      System.out.println("Зовнішній else: x не більший за 10");
    }
  }
}
