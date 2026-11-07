package semester1.practice05;

import java.util.Arrays;

public class Ex22 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] test = {45, 12, 89, 3, 27};
    System.out.println(Arrays.toString(test));
    Arrays.sort(test);
    System.out.println(Arrays.toString(test));
    Arrays.fill(test, -1);
    System.out.println(Arrays.toString(test));
  }
}
