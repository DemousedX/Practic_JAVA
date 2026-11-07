package semester1.practice08;

public final class Ex11 {
  private Ex11() {}

  static class Vehicle {
    protected String brand;
    protected int maxSpeed;
    protected double fuelTankCapacity;

    Vehicle(String brand, int maxSpeed, double capacity) {
      this.brand = brand;
      this.maxSpeed = maxSpeed;
      fuelTankCapacity = capacity;
    }

    @Override
    public String toString() {
      return brand + ", max speed=" + maxSpeed + " km/h, tank=" + fuelTankCapacity + " L";
    }
  }

  static class PassengerCar extends Vehicle {
    private int passengerSeats;

    PassengerCar(String brand, int speed, double tank, int seats) {
      super(brand, speed, tank);
      passengerSeats = seats;
    }

    @Override
    public String toString() {
      return "PassengerCar{" + super.toString() + ", seats=" + passengerSeats + "}";
    }
  }

  static class CargoTruck extends Vehicle {
    private double maxLoadTons;

    CargoTruck(String brand, int speed, double tank, double load) {
      super(brand, speed, tank);
      maxLoadTons = load;
    }

    public double fullLoadFuelUse() {
      return fuelTankCapacity + maxLoadTons * 2;
    }

    @Override
    public String toString() {
      return "CargoTruck{"
          + super.toString()
          + ", load="
          + maxLoadTons
          + " t, full-load use="
          + fullLoadFuelUse()
          + " L}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 11 ---%n");

    System.out.println(new PassengerCar("Toyota", 180, 55, 5));
    System.out.println(new CargoTruck("Volvo", 110, 300, 18));
  }
}
