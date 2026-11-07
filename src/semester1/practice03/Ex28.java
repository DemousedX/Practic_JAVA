package semester1.practice03;

public class Ex28 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int counterA = 0, counterB = 0;
    boolean test1 = true || (++counterA > 0);
    boolean test2 = true | (++counterB > 0);
    System.out.println(counterA + " " + counterB);
    System.out.println(test1 + " " + test2);
    System.out.println("|| пропускає праву частину, | обчислює обидві");
  }
}
