package semester1.practice04;

public class Ex23 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%5s | %7s | %5s%n", "Число", "Квадрат", "Куб");
    for (int i = 1; i <= 10; i++) {
      System.out.printf("%5d | %7d | %5d%n", i, i * i, i * i * i);
    }
  }
}
