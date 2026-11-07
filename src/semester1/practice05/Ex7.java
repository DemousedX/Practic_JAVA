package semester1.practice05;

import java.util.Arrays;

public class Ex7 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] original = {3, 7, 1, 9, 4}, copy = new int[original.length];
    for (int i = 0; i < original.length; i++) {
      copy[i] = original[i];
    }
    copy[0] = 999;
    System.out.println(Arrays.toString(original));
    System.out.println(Arrays.toString(copy));
  }
}
