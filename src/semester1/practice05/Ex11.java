package semester1.practice05;


public class Ex11 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] data = {12, 5, 8, 19, 24, 3, 16, -7, 0, 11};
    int evens = 0, oddSum = 0;
    for (int n : data) {
      if (n % 2 == 0) {
        evens++;
      } else {
        oddSum += n;
      }
    }
    System.out.println("Парних: " + evens + ", сума непарних: " + oddSum);
  }
}
