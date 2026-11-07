package semester1.practice05;

import java.util.Arrays;

public class Ex21 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] a = {1, 2, 3}, b = {4, 5, 6, 7}, c = new int[a.length + b.length];
    for (int i = 0; i < a.length; i++) {
      c[i] = a[i];
    }
    for (int i = 0; i < b.length; i++) {
      c[a.length + i] = b[i];
    }
    System.out.println(Arrays.toString(c));
  }
}
