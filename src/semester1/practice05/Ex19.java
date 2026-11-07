package semester1.practice05;

import java.util.Arrays;

public class Ex19 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] base = {2, 4, 6, 8, 10}, squares = new int[base.length];
    for (int i = 0; i < base.length; i++) {
      squares[i] = base[i] * base[i];
    }
    System.out.println(Arrays.toString(base));
    System.out.println(Arrays.toString(squares));
  }
}
