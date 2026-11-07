package semester1.practice06;

public class Ex7 {
  static class Point2D {
    double x, y;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Point2D a = new Point2D(), b = new Point2D();
    a.x = 0;
    a.y = 0;
    b.x = 3;
    b.y = 4;
    double distance = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    System.out.println(distance);
  }
}
