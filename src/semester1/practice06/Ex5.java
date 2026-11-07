package semester1.practice06;

public class Ex5 {
  static class Product {
    String name;
    double price;
    int quantity;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Product p = new Product();
    p.name = "Монітор";
    p.price = 6500;
    p.quantity = 8;
    System.out.println(p.name + ": " + p.price * p.quantity + " грн");
  }
}
