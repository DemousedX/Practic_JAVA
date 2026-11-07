package semester1.practice06;

public class Ex6 {
  static class Smartphone {
    String model;
    int batteryLevel;
    boolean isTurnedOn;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Smartphone p = new Smartphone();
    p.model = "Samsung";
    p.batteryLevel = 100;
    p.isTurnedOn = true;
    p.batteryLevel -= 35;
    if (p.batteryLevel <= 0) p.isTurnedOn = false;
    System.out.println(p.model + " | заряд " + p.batteryLevel + "% | увімкнений " + p.isTurnedOn);
  }
}
