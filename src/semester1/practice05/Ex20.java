package semester1.practice05;


public class Ex20 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] arr = {1, 3, 3, 7, 9};
    boolean isSorted = true;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        isSorted = false;
        break;
      }
    }
    System.out.println("Відсортовано: " + isSorted);
  }
}
