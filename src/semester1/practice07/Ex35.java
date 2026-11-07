package semester1.practice07;

public class Ex35 {
  static class Engine {
    String serialNumber;
    int horsePower;
    boolean isRunning;

    public Engine(String serialNumber, int horsePower) {
      this.serialNumber = serialNumber;
      this.horsePower = horsePower;
    }

    public void start() {
      isRunning = true;
    }

    public void stop() {
      isRunning = false;
    }

    public boolean isRunning() {
      return isRunning;
    }
  }

  static class CarWithEngine {
    String brand, model;
    Engine engine;

    public CarWithEngine(String brand, String model, Engine engine) {
      this.brand = brand;
      this.model = model;
      this.engine = engine;
    }

    public void startCar() {
      this.engine.start();
      System.out.println(brand + " готовий до руху!");
    }

    public void turnOff() {
      this.engine.stop();
    }

    public void printSpecs() {
      System.out.println(
          brand
              + " "
              + model
              + " | "
              + engine.horsePower
              + " к.с. | "
              + engine.serialNumber
              + " | "
              + engine.isRunning());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    CarWithEngine c = new CarWithEngine("Toyota", "Corolla", new Engine("E100", 150));
    c.printSpecs();
    c.startCar();
    c.printSpecs();
    c.turnOff();
    c.printSpecs();
  }
}
