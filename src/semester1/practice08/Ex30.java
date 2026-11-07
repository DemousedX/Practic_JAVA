package semester1.practice08;

public final class Ex30 {
  private Ex30() {}

  static class Segment1D {
    protected double length;

    Segment1D(double length) {
      this.length = Math.max(0, length);
    }

    @Override
    public String toString() {
      return "Segment1D{length=" + length + "}";
    }
  }

  static class Square2D extends Segment1D {
    Square2D(double side) {
      super(side);
    }

    public double getPerimeter() {
      return 4 * length;
    }

    public double getArea() {
      return length * length;
    }

    @Override
    public String toString() {
      return "Square2D{side="
          + length
          + ", perimeter="
          + getPerimeter()
          + ", area="
          + getArea()
          + "}";
    }
  }

  static class Cube3D extends Square2D {
    Cube3D(double side) {
      super(side);
    }

    @Override
    public double getArea() {
      return 6 * super.getArea();
    }

    public double getVolume() {
      return length * length * length;
    }

    @Override
    public String toString() {
      return "Cube3D{side=" + length + ", surface=" + getArea() + ", volume=" + getVolume() + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 30 ---%n");

    System.out.println(new Segment1D(3));
    System.out.println(new Square2D(3));
    System.out.println(new Cube3D(3));
  }
}
