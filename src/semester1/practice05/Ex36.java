package semester1.practice05;

import java.util.Arrays;

public class Ex36 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[][] ladder = new int[4][];
    for (int i = 0; i < ladder.length; i++) {
      ladder[i] = new int[i + 1];
      Arrays.fill(ladder[i], i);
      System.out.println(Arrays.toString(ladder[i]));
    }
  }
}
