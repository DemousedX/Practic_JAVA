package semester1.practice06;

public class Ex36 {
  static class TemperatureTracker {
    private double[] dailyTemps = new double[7];

    public void setTemps(double[] temps) {
      if (temps.length != 7) throw new IllegalArgumentException("Потрібно 7 температур");
      dailyTemps = temps.clone();
    }

    public int countDaysAbove(double threshold) {
      int count = 0;
      for (double t : dailyTemps) if (t > threshold) count++;
      return count;
    }

    public void printWeeklyReport() {
      int max = 0;
      for (int i = 0; i < 7; i++) {
        System.out.println("День " + (i + 1) + ": " + dailyTemps[i]);
        if (dailyTemps[i] > dailyTemps[max]) max = i;
      }
      System.out.println("Найтепліший день: " + (max + 1));
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    TemperatureTracker t = new TemperatureTracker();
    t.setTemps(new double[] {18, 20, 19, 22, 21, 17, 16});
    t.printWeeklyReport();
    System.out.println("Вище 19: " + t.countDaysAbove(19));
  }
}
