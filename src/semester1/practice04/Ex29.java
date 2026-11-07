package semester1.practice04;

public class Ex29 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    byte b = 125;
    for (int i = 0; i < 6; i++) {
      b = (byte) (b + 1);
      System.out.println(b);
    }
    System.out.println("Після 127 тип byte переповнюється до -128");
  }
}
