package semester1.practice04;

public class Ex36 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= 10; j++) {
        System.out.printf("%4d", i * j);
      }
      System.out.println();
    }
  }
}
