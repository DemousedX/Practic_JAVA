package semester1.practice03;

public class Ex25 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int x = 10, divisor = 0;
    if (divisor != 0 && (x / divisor > 1)) {
      System.out.println("Успішне ділення");
    } else {
      System.out.println("Ділення безпечно пропущено завдяки short-circuit!");
    }
    System.out.println("Права частина && не обчислюється, коли ліва дорівнює false");
  }
}
