package semester1.practice10;

public class Ex25 {

  public static void inspect(Ex2.Shape2D[] shapes) {
    for (Ex2.Shape2D shape : shapes) {
      if (shape instanceof Ex2.CircleShape c) System.out.println("Діаметр: " + c.getDiameter());
      else if (shape instanceof Ex2.RectangleShape r)
        System.out.println("Діагональ: " + r.getDiagonal() + ", квадрат: " + r.isSquare());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    inspect(
        new Ex2.Shape2D[] {
          new Ex2.CircleShape(5),
          new Ex2.RectangleShape(3, 4),
          new Ex2.RectangleShape(4, 4),
          new Ex2.EquilateralTriangleShape(3),
          null
        });
    System.out.println("null instanceof Shape2D: " + (null instanceof Ex2.Shape2D));
  }
}
