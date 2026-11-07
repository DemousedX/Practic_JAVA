package semester1.practice05;


public class Ex15 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    double[] prices = {42.5, 41.8, 44.1, 40.9, 43.6, 45.0};
    double min = prices[0], max = prices[0];
    for (double value : prices) {
      min = Math.min(min, value);
      max = Math.max(max, value);
    }
    System.out.printf("Розмах: %.2f%n", max - min);
  }
}
