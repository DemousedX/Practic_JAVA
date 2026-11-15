package semester1.practice10;

public class Ex15 {

  interface Transformable2D {
    void translate(double dx, double dy);

    void scale(double factor);
  }

  static class BoundingBox implements Transformable2D {
    private double x, y, w, h;

    BoundingBox(double x, double y, double w, double h) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
    }

    @Override
    public void translate(double dx, double dy) {
      x += dx;
      y += dy;
    }

    @Override
    public void scale(double factor) {
      if (factor <= 0) throw new IllegalArgumentException("Масштаб має бути додатним");
      x *= factor;
      y *= factor;
      w *= factor;
      h *= factor;
    }

    @Override
    public String toString() {
      return String.format("Рамка (%.1f; %.1f), %.1fx%.1f", x, y, w, h);
    }
  }

  static class CircleRegion implements Transformable2D {
    private double x, y, r;

    CircleRegion(double x, double y, double r) {
      this.x = x;
      this.y = y;
      this.r = r;
    }

    @Override
    public void translate(double dx, double dy) {
      x += dx;
      y += dy;
    }

    @Override
    public void scale(double factor) {
      if (factor <= 0) throw new IllegalArgumentException("Масштаб має бути додатним");
      x *= factor;
      y *= factor;
      r *= factor;
    }

    @Override
    public String toString() {
      return String.format("Коло (%.1f; %.1f), r=%.1f", x, y, r);
    }
  }

  static void applyGlobalTransform(
      Transformable2D[] objects, double dx, double dy, double scaleFactor) {
    for (Transformable2D t : objects) {
      t.translate(dx, dy);
      t.scale(scaleFactor);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    Transformable2D[] objects = {new BoundingBox(0, 0, 4, 6), new CircleRegion(1, 2, 5)};
    for (Transformable2D t : objects) System.out.println(t);
    applyGlobalTransform(objects, 2, 3, 2);
    for (Transformable2D t : objects) System.out.println(t);
  }
}
