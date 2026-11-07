package semester1.practice08;

public final class Ex12 {
  private Ex12() {}

  static class Rectangle {
    private double width, height;

    Rectangle(double width, double height) {
      this.width = Math.max(0, width);
      this.height = Math.max(0, height);
    }

    public double getWidth() {
      return width;
    }

    public double getHeight() {
      return height;
    }

    public double getArea() {
      return width * height;
    }

    @Override
    public String toString() {
      return "Rectangle{" + width + " x " + height + ", area=" + getArea() + "}";
    }
  }

  static class Box3D extends Rectangle {
    private double depth;

    Box3D(double width, double height, double depth) {
      super(width, height);
      this.depth = Math.max(0, depth);
    }

    public double getVolume() {
      return super.getArea() * depth;
    }

    @Override
    public String toString() {
      return "Box3D{baseArea="
          + super.getArea()
          + ", depth="
          + depth
          + ", volume="
          + getVolume()
          + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 12 ---%n");

    System.out.println(new Rectangle(4, 5));
    System.out.println(new Box3D(4, 5, 6));
  }
}
