package semester1.practice06;

public class Ex29 {
  static class CarSpeedometer {
    private int speed = 0;

    public void accelerate(int delta) {
      if (delta > 0) speed = (int) Math.min(240, (long) speed + delta);
    }

    public void brake(int delta) {
      if (delta > 0) speed = Math.max(0, speed - delta);
    }

    public int getSpeed() {
      return speed;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    CarSpeedometer s = new CarSpeedometer();
    s.accelerate(300);
    System.out.println(s.getSpeed());
    s.brake(500);
    System.out.println(s.getSpeed());
  }
}
