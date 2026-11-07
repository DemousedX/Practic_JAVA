package semester1.practice04;

public class Ex3 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int balance = 0;
    for (int month = 1; month <= 12; month++) {
      balance += 500;
      System.out.println("Місяць " + month + ": " + balance + " грн");
    }
  }
}
