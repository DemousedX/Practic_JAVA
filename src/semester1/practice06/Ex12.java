package semester1.practice06;

public class Ex12 {
  static class TrafficLight {
    String currentColor;

    public void changeColor(String newColor) {
      currentColor = newColor;
    }

    public void showSignal() {
      System.out.println(
          switch (currentColor) {
            case "Червоний" -> "Стій!";
            case "Жовтий" -> "Увага!";
            case "Зелений" -> "Їдь!";
            default -> "Невідомий колір";
          });
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    TrafficLight t = new TrafficLight();
    for (String c : new String[] {"Червоний", "Жовтий", "Зелений"}) {
      t.changeColor(c);
      t.showSignal();
    }
  }
}
