package semester1.practice04;

public class Ex34 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    long bigNumber = 3_000_000_000L;
    int number = (int) bigNumber;
    System.out.println(bigNumber);
    System.out.println(number);
    System.out.println("Після звуження залишаються тільки молодші 32 біти");
  }
}
