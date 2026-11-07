package semester1.practice04;

public class Ex25 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (int i = 100; i <= 200; i++) {
      if (i % 13 == 0 && i % 7 == 0) {
        System.out.println(i);
        break;
      }
    }
  }
}
