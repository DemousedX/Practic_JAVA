package semester1.practice09;

public class Ex10 {
  static class Engine {
    private final String fuelType;
    private final int volumeCc;
    private int rpm;
    private boolean started;

    public Engine(String fuelType, int volumeCc) {
      this.fuelType = fuelType;
      this.volumeCc = volumeCc;
    }

    public void start() {
      started = true;
      rpm = 800;
    }

    public void stop() {
      started = false;
      rpm = 0;
    }

    public void setRpm(int rpm) {
      this.rpm = started ? Math.max(0, rpm) : 0;
    }

    public boolean isStarted() {
      return started;
    }

    public String toString() {
      return fuelType + " | " + volumeCc + " cc | rpm=" + rpm + " | started=" + started;
    }
  }

  static class Automobile {
    private final String model;
    private double speed;
    private final Engine engine;

    public Automobile(String model, Engine engine) {
      this.model = model;
      this.engine = engine;
    }

    public void accelerate(double deltaSpeed) {
      if (engine.isStarted() && deltaSpeed > 0) {
        speed += deltaSpeed;
        engine.setRpm(800 + (int) (speed * 40));
      }
    }

    public String toString() {
      return model + " | speed=" + speed + " | " + engine;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Engine e = new Engine("petrol", 2000);
    Automobile c = new Automobile("Toyota", e);
    c.accelerate(20);
    System.out.println(c);
    e.start();
    c.accelerate(20);
    System.out.println(c);
    e.stop();
    System.out.println(c);
  }
}
