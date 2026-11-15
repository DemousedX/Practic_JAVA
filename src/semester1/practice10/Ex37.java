package semester1.practice10;

public class Ex37 {

  interface PowerProducer {
    double produceMw();
  }

  interface WeatherDependent {
    void updateWeatherCondition(double factor);
  }

  abstract static class AbstractPowerStation implements PowerProducer {
    private final String stationId;

    AbstractPowerStation(String id) {
      stationId = id;
    }

    public final double getNetOutputMw() {
      return produceMw() * 0.95;
    }

    public String getStationId() {
      return stationId;
    }
  }

  static class NuclearStation extends AbstractPowerStation {
    NuclearStation() {
      super("N-01");
    }

    @Override
    public double produceMw() {
      return 1000;
    }
  }

  static class SolarFarmStation extends AbstractPowerStation implements WeatherDependent {
    private double factor = 1;

    SolarFarmStation() {
      super("S-01");
    }

    @Override
    public void updateWeatherCondition(double factor) {
      this.factor = Math.max(0, Math.min(1, factor));
    }

    @Override
    public double produceMw() {
      return 100 * factor;
    }
  }

  static class HydroDamStation extends AbstractPowerStation implements WeatherDependent {
    private double factor = 1;

    HydroDamStation() {
      super("H-01");
    }

    @Override
    public void updateWeatherCondition(double factor) {
      this.factor = Math.max(0, Math.min(1, factor));
    }

    @Override
    public double produceMw() {
      return 200 * factor;
    }
  }

  static class SmartGridController {
    double calculateOutput(PowerProducer[] stations, double weatherFactor) {
      double total = 0;
      for (PowerProducer p : stations) {
        if (p instanceof WeatherDependent w) w.updateWeatherCondition(weatherFactor);
        total += p instanceof AbstractPowerStation s ? s.getNetOutputMw() : p.produceMw() * 0.95;
      }
      return total;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    PowerProducer[] stations = {
      new NuclearStation(), new SolarFarmStation(), new HydroDamStation()
    };
    System.out.println(
        "Чиста генерація: " + new SmartGridController().calculateOutput(stations, 0.6) + " МВт");
  }
}
