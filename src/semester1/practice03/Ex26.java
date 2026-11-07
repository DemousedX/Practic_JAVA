package semester1.practice03;

public class Ex26 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int counter1 = 0, counter2 = 0;
    boolean b1 = false && (++counter1 > 0);
    boolean b2 = false & (++counter2 > 0);
    System.out.println(counter1 + " " + counter2);
    System.out.println(b1 + " " + b2);
    System.out.println("&& пропускає праву частину, & обчислює обидві");
  }
}
