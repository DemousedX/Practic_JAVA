package semester1.practice06;

public class Ex2 {
  static class Car {
    String brand, model;
    int year, speed;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Car a = new Car(), b = new Car();
    a.brand = "Toyota";
    a.model = "Camry";
    a.year = 2021;
    a.speed = 180;
    b.brand = "BMW";
    b.model = "M5";
    b.year = 2023;
    b.speed = 250;
    for (Car c : new Car[] {a, b})
      System.out.println(c.brand + " " + c.model + " " + c.year + " " + c.speed);
    System.out.println("Новіше авто: " + (a.year > b.year ? a.brand : b.brand));
  }
}
