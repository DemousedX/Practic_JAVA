package semester1.practice05;


public class Ex10 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] data = {12, -5, 0, 43, -19, 0, -2, 8, 0, 15};
    int positive = 0, negative = 0, zero = 0;
    for (int n : data) {
      if (n > 0) {
        positive++;
      } else if (n < 0) {
        negative++;
      } else {
        zero++;
      }
    }
    System.out.println("Додатних: " + positive + ", від'ємних: " + negative + ", нулів: " + zero);
  }
}
