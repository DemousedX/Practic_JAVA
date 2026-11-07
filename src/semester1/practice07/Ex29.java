package semester1.practice07;

public class Ex29 {
  static class FleetCar {
    private String vinCode;
    private double currentMileage;
    private static int totalCars = 0;
    private static double totalCompanyMileage = 0;

    public FleetCar(String vinCode, double initialMileage) {
      this.vinCode = vinCode;
      currentMileage = Math.max(0, initialMileage);
      totalCars++;
      totalCompanyMileage += currentMileage;
    }

    public void addTrip(double km) {
      if (km > 0) {
        currentMileage += km;
        totalCompanyMileage += km;
      }
    }

    public static void printFleetSummary() {
      System.out.println("Авто: " + totalCars + ", пробіг: " + totalCompanyMileage + " км");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    FleetCar a = new FleetCar("VIN1", 100),
        b = new FleetCar("VIN2", 200),
        c = new FleetCar("VIN3", 300);
    a.addTrip(50);
    b.addTrip(100);
    c.addTrip(150);
    FleetCar.printFleetSummary();
  }
}
