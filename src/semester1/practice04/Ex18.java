package semester1.practice04;

public class Ex18 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int a, b, attempts = 0;
    do {
      a = (int) (Math.random() * 6) + 1;
      b = (int) (Math.random() * 6) + 1;
      attempts++;
      System.out.println("Кидок " + attempts + ": " + a + " " + b);
    } while (a != b);
    System.out.println("Дубль за " + attempts + " спроб");
  }
}
