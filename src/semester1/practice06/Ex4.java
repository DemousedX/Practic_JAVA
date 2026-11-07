package semester1.practice06;

public class Ex4 {
  static class Rectangle {
    double width, height;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Rectangle r = new Rectangle();
    r.width = 7.5;
    r.height = 4;
    System.out.println("Площа: " + r.width * r.height);
    System.out.println("Периметр: " + 2 * (r.width + r.height));
  }
}
