package semester1.practice10;

public class Ex20 {

  static class Vec2D {
    final double x, y;

    Vec2D(double x, double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return String.format("(%.4f; %.4f)", x, y);
    }
  }

  abstract static class AbstractVectorOperator {
    private final String name;

    AbstractVectorOperator(String name) {
      this.name = name;
    }

    public abstract Vec2D transform(Vec2D v);

    public String getName() {
      return name;
    }
  }

  interface InvertibleOperator {
    Vec2D inverseTransform(Vec2D v);
  }

  static class Rotation2DOperator extends AbstractVectorOperator implements InvertibleOperator {
    private final double angle;

    Rotation2DOperator(double angle) {
      super("Поворот");
      this.angle = angle;
    }

    private Vec2D rotate(Vec2D v, double a) {
      return new Vec2D(
          v.x * Math.cos(a) - v.y * Math.sin(a), v.x * Math.sin(a) + v.y * Math.cos(a));
    }

    @Override
    public Vec2D transform(Vec2D v) {
      return rotate(v, angle);
    }

    @Override
    public Vec2D inverseTransform(Vec2D v) {
      return rotate(v, -angle);
    }
  }

  static class ProjectionXOperator extends AbstractVectorOperator {
    ProjectionXOperator() {
      super("Проєкція OX");
    }

    @Override
    public Vec2D transform(Vec2D v) {
      return new Vec2D(v.x, 0);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    Vec2D v = new Vec2D(3, 4);
    for (AbstractVectorOperator op :
        new AbstractVectorOperator[] {
          new Rotation2DOperator(Math.PI / 3), new ProjectionXOperator()
        }) {
      Vec2D result = op.transform(v);
      System.out.println(op.getName() + ": " + result);
      if (op instanceof InvertibleOperator inv)
        System.out.println("Відновлено: " + inv.inverseTransform(result));
    }
  }
}
