package semester1.practice04;

public class Ex24 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (int i = 1; i <= 50; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        continue;
      }
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
