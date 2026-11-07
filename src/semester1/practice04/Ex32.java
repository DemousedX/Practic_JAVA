package semester1.practice04;

public class Ex32 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    double[] prices = {19.99, 45.50, 12.10, 99.95, 3.40};
    int hryvnias = 0, kopecks = 0;
    for (double price : prices) {
      int whole = (int) price;
      hryvnias += whole;
      kopecks += (int) Math.round((price - whole) * 100);
    }
    System.out.println("Цілі гривні: " + hryvnias);
    System.out.println("Відкинуті копійки: " + kopecks);
  }
}
