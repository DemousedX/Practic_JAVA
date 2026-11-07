package semester1.practice05;


public class Ex5 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] arr = {4, 8, 15, 16, 23, 42};
    for (int i = arr.length - 1; i >= 0; i--) {
      System.out.print(arr[i] + (i > 0 ? ", " : ""));
    }
    System.out.println();
  }
}
