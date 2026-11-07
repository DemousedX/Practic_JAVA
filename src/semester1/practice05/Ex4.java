package semester1.practice05;

import java.util.Arrays;

public class Ex4 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
      System.out.print("N > 0: ");
      int n = scanner.nextInt();
      if (n <= 0) {
        System.out.println("Потрібне додатне число");
        return;
      }
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
      }
      System.out.println(Arrays.toString(arr));
    }
  }
}
