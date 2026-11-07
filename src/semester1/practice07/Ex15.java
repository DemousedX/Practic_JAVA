package semester1.practice07;

public class Ex15 {
  static class Box {
    private double width, height, depth;
    private String material;

    public Box(double width, double height, double depth, String material) {
      this.width = width;
      this.height = height;
      this.depth = depth;
      this.material = material;
    }

    public Box(double size, String material) {
      this(size, size, size, material);
    }

    public Box(Box other) {
      this(other.width, other.height, other.depth, other.material);
    }

    public double getVolume() {
      return width * height * depth;
    }

    public double getSurfaceArea() {
      return 2 * (width * height + width * depth + height * depth);
    }

    public void printBox() {
      System.out.printf(
          "%s | %.2f x %.2f x %.2f | V=%.2f | S=%.2f%n",
          material, width, height, depth, getVolume(), getSurfaceArea());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Box a = new Box(3, "Картон"), b = new Box(a);
    a.printBox();
    b.printBox();
    System.out.println(a.getVolume() == b.getVolume());
  }
}
