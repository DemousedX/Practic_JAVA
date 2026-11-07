package semester1.practice06;

public class Ex28 {
  static class Thermometer {
    private double temperature;

    public void setTemperature(double t) {
      if (t < -273.15) {
        System.out.println("Температура нижча за абсолютний нуль");
        return;
      }
      temperature = t;
    }

    public double getTemperature() {
      return temperature;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Thermometer t = new Thermometer();
    t.setTemperature(20);
    t.setTemperature(-300);
    System.out.println(t.getTemperature());
  }
}
