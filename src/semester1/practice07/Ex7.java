package semester1.practice07;

public class Ex7 {
  static class Rectangle {
    private double width, height;

    public Rectangle() {
      this(1, 1);
    }

    public Rectangle(double size) {
      this(size, size);
    }

    public Rectangle(double width, double height) {
      this.width = width;
      this.height = height;
    }

    public double getArea() {
      return width * height;
    }

    public double getPerimeter() {
      return 2 * (width + height);
    }

    public boolean isSquare() {
      return width == height;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (Rectangle r : new Rectangle[] {new Rectangle(), new Rectangle(3), new Rectangle(2, 4)})
      System.out.printf(
          "Площа %.2f, периметр %.2f, квадрат %s%n", r.getArea(), r.getPerimeter(), r.isSquare());
  }
}
