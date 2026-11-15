package semester1.practice10;

public class Ex5 {

  abstract static class ShippingTariff {
    public abstract double calculateCost(double weightKg, double distanceKm);
  }

  static class RoadTruckTariff extends ShippingTariff {
    @Override
    public double calculateCost(double w, double d) {
      return 15 * d + 2.5 * w;
    }
  }

  static class AirCargoTariff extends ShippingTariff {
    @Override
    public double calculateCost(double w, double d) {
      return 45 * d + 18 * w + 500;
    }
  }

  static class RailFreightTariff extends ShippingTariff {
    @Override
    public double calculateCost(double w, double d) {
      return 1200 + 4 * d + 0.8 * w;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    ShippingTariff[] tariffs = {
      new RoadTruckTariff(), new AirCargoTariff(), new RailFreightTariff()
    };
    ShippingTariff best = tariffs[0];
    for (ShippingTariff t : tariffs) {
      System.out.printf("%s: %.2f грн%n", t.getClass().getSimpleName(), t.calculateCost(250, 600));
      if (t.calculateCost(250, 600) < best.calculateCost(250, 600)) best = t;
    }
    System.out.println("Найвигідніший тариф: " + best.getClass().getSimpleName());
  }
}
