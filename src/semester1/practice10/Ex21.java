package semester1.practice10;

public class Ex21 {

  abstract static class AbstractVehicle {
    private final String plateNumber;
    protected double mileageKm;

    AbstractVehicle(String plateNumber, double mileageKm) {
      this.plateNumber = plateNumber;
      this.mileageKm = mileageKm;
    }

    public String getPlateNumber() {
      return plateNumber;
    }
  }

  interface CargoCarrier {
    double getMaxPayloadTons();
  }

  interface PassengerCarrier {
    int getSeatCount();
  }

  interface ElectricPowered {
    double getBatteryCapacityKwh();
  }

  static class ElectricCityBus extends AbstractVehicle
      implements PassengerCarrier, ElectricPowered {
    ElectricCityBus() {
      super("BUS-01", 12000);
    }

    @Override
    public int getSeatCount() {
      return 40;
    }

    @Override
    public double getBatteryCapacityKwh() {
      return 300;
    }
  }

  static class DieselDumpTruck extends AbstractVehicle implements CargoCarrier {
    DieselDumpTruck() {
      super("TRUCK-01", 40000);
    }

    @Override
    public double getMaxPayloadTons() {
      return 20;
    }
  }

  static class CargoPassengerVan extends AbstractVehicle implements CargoCarrier, PassengerCarrier {
    CargoPassengerVan() {
      super("VAN-01", 20000);
    }

    @Override
    public double getMaxPayloadTons() {
      return 1.5;
    }

    @Override
    public int getSeatCount() {
      return 6;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    for (AbstractVehicle v :
        new AbstractVehicle[] {
          new ElectricCityBus(), new DieselDumpTruck(), new CargoPassengerVan()
        }) {
      System.out.println(v.getPlateNumber());
      if (v instanceof CargoCarrier c) System.out.println("Вантажність: " + c.getMaxPayloadTons());
      if (v instanceof PassengerCarrier p) System.out.println("Місць: " + p.getSeatCount());
      if (v instanceof ElectricPowered e)
        System.out.println("Батарея: " + e.getBatteryCapacityKwh());
    }
  }
}
