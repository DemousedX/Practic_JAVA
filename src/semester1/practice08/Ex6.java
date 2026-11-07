package semester1.practice08;

import java.util.Arrays;

public final class Ex6 {
  private Ex6() {}

  static class WeatherDay {
    private String date;
    private double[] hourlyTemps;

    WeatherDay(String date, double[] values) {
      this.date = date;
      hourlyTemps = new double[values.length];
      for (int i = 0; i < values.length; i++) {
        hourlyTemps[i] = values[i];
      }
    }

    public double getMinTemp() {
      return Arrays.stream(hourlyTemps).min().orElse(0);
    }

    public double getMaxTemp() {
      return Arrays.stream(hourlyTemps).max().orElse(0);
    }

    public double getAverageTemp() {
      return Arrays.stream(hourlyTemps).average().orElse(0);
    }

    @Override
    public String toString() {
      return String.format(
          "WeatherDay{date='%s', temperatures=%s, average=%.2f}",
          date, Arrays.toString(hourlyTemps), getAverageTemp());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 06 ---%n");

    double[] values = {12.1, 14.2, 17.4, 16.8, 11.3};
    WeatherDay day = new WeatherDay("2026-11-06", values);
    values[0] = 99;
    System.out.println(day);
    System.out.printf("Min: %.1f, max: %.1f%n", day.getMinTemp(), day.getMaxTemp());
  }
}
