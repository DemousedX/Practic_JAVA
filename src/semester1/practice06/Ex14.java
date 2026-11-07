package semester1.practice06;

public class Ex14 {
  static class Lamp {
    boolean isOn;

    public void turnOn() {
      isOn = true;
    }

    public void turnOff() {
      isOn = false;
    }

    public void toggle() {
      isOn = !isOn;
    }

    public void status() {
      System.out.println(isOn ? "Лампа світить" : "Лампа вимкнена");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Lamp l = new Lamp();
    l.status();
    l.toggle();
    l.status();
    l.toggle();
    l.status();
    l.turnOn();
    l.status();
    l.turnOff();
    l.status();
  }
}
