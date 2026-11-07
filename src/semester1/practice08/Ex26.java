package semester1.practice08;

public class Ex26 {
  static class BaseVehicle {
    String brand;
    int year;

    public BaseVehicle(String brand, int year) {
      this.brand = brand;
      this.year = year;
    }

    public String toString() {
      return brand + " | " + year;
    }
  }

  static class MotorCar extends BaseVehicle {
    int horsePower, doorsCount;

    public MotorCar(String brand, int year, int horsePower, int doorsCount) {
      super(brand, year);
      this.horsePower = horsePower;
      this.doorsCount = doorsCount;
    }

    public String toString() {
      return super.toString() + " | " + horsePower + " к.с. | дверей: " + doorsCount;
    }
  }

  static class ElectricCar extends MotorCar {
    double batteryCapacityKWh;
    int rangeKm;

    public ElectricCar(
        String brand,
        int year,
        int horsePower,
        int doorsCount,
        double batteryCapacityKWh,
        int rangeKm) {
      super(brand, year, horsePower, doorsCount);
      this.batteryCapacityKWh = batteryCapacityKWh;
      this.rangeKm = rangeKm;
    }

    public String toString() {
      return super.toString() + " | " + batteryCapacityKWh + " kWh | " + rangeKm + " km";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new ElectricCar("Tesla", 2024, 300, 4, 75, 450));
  }
}
