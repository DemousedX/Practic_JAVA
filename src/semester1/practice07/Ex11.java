package semester1.practice07;

public class Ex11 {
  static class Car {
    String brand, model;
    int year;
    double mileage;
    boolean engineStarted;

    public Car(String brand, String model, int year, double mileage) {
      this.brand = brand;
      this.model = model;
      this.year = year;
      this.mileage = mileage;
    }

    public Car(String brand, String model, int year) {
      this(brand, model, year, 0);
    }

    public Car() {
      this("Unknown", "Standard", 2024);
    }

    public void startEngine() {
      engineStarted = true;
    }

    public void stopEngine() {
      engineStarted = false;
    }

    public void drive(double distance) {
      if (!engineStarted) System.out.println("Спершу заведіть двигун!");
      else if (distance > 0) mileage += distance;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Car c = new Car("Toyota", "Corolla", 2024);
    c.drive(10);
    c.startEngine();
    c.drive(150);
    c.stopEngine();
    System.out.println(c.brand + " " + c.model + " " + c.mileage + " км");
  }
}
