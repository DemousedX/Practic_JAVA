package semester1.practice06;

public class Ex34 {
  static class ArrayStats {
    private int[] numbers = new int[0];

    public void setNumbers(int[] nums) {
      numbers = nums.clone();
    }

    public int countEvens() {
      int n = 0;
      for (int x : numbers) if (x % 2 == 0) n++;
      return n;
    }

    public int countOdds() {
      return numbers.length - countEvens();
    }

    public int calculateSum() {
      int sum = 0;
      for (int x : numbers) sum += x;
      return sum;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ArrayStats a = new ArrayStats();
    a.setNumbers(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    System.out.println(
        "Парних: "
            + a.countEvens()
            + ", непарних: "
            + a.countOdds()
            + ", сума: "
            + a.calculateSum());
  }
}
