package semester1.practice03;

public class Ex27 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int number = 5;
    if (number > 0 || (10 / 0 == 0)) {
      System.out.println("Умова виконана, аварійне ділення не викликалося!");
    }
    System.out.println("Перша частина || істинна, друга не обчислюється");
  }
}
