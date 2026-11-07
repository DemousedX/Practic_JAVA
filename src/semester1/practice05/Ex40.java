package semester1.practice05;


public class Ex40 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    String[] cities = {"Київ", "Львів", "Одеса"};
    double[][][] weather = new double[3][7][2];
    double coldest = Double.POSITIVE_INFINITY;
    for (int city = 0; city < 3; city++) {
      double sum = 0;
      for (int day = 0; day < 7; day++) {
        weather[city][day][0] = 15 + city * 2 + day * 0.4;
        weather[city][day][1] = 7 + city * 2 - day * 0.3;
        sum += weather[city][day][0];
        coldest = Math.min(coldest, weather[city][day][1]);
      }
      System.out.printf("%s: середня денна %.2f deg C%n", cities[city], sum / 7);
    }
    System.out.printf("Найхолодніша ніч: %.2f deg C%n", coldest);
  }
}
