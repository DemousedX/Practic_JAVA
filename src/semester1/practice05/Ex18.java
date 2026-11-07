package semester1.practice05;

import java.util.Arrays;

public class Ex18 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] arr = {1, 2, 3, 4, 5, 6};
    for (int i = 0; i < arr.length / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }
}
