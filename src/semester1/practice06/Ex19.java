package semester1.practice06;

public class Ex19 {
  static class TemperatureConverter {
    public double celsiusToFahrenheit(double c) {
      return c * 1.8 + 32;
    }

    public double fahrenheitToCelsius(double f) {
      return (f - 32) / 1.8;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    TemperatureConverter t = new TemperatureConverter();
    double f = t.celsiusToFahrenheit(25);
    System.out.println(f);
    System.out.println(t.fahrenheitToCelsius(f));
  }
}
