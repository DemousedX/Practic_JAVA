package semester1.practice05;


public class Ex13 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
      int[] rolls = {3, 6, 2, 6, 1, 4, 6, 5, 2, 6};
      System.out.print("Число 1-6: ");
      int target = scanner.nextInt(), count = 0;
      if (target < 1 || target > 6) {
        System.out.println("Число поза діапазоном");
        return;
      }
      for (int value : rolls) {
        if (value == target) {
          count++;
        }
      }
      System.out.println("Кількість: " + count);
    }
  }
}
