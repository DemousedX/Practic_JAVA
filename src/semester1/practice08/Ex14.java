package semester1.practice08;

public final class Ex14 {
  private Ex14() {}

  static class Gadget {
    private String brand;
    private double price;

    Gadget(String brand, double price) {
      this.brand = brand;
      this.price = Math.max(0, price);
    }

    public String getBrand() {
      return brand;
    }

    public double getPrice() {
      return price;
    }
  }

  static class Smartphone extends Gadget {
    private int memoryGb;
    private boolean has5G;

    Smartphone(String brand) {
      this(brand, 9999.0, 128, false);
    }

    Smartphone(String brand, double price, int memoryGb) {
      this(brand, price, memoryGb, true);
    }

    Smartphone(String brand, double price, int memoryGb, boolean has5G) {
      super(brand, price);
      this.memoryGb = memoryGb;
      this.has5G = has5G;
    }

    @Override
    public String toString() {
      return "Smartphone{"
          + getBrand()
          + ", price="
          + getPrice()
          + ", memory="
          + memoryGb
          + " GB, 5G="
          + has5G
          + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 14 ---%n");

    System.out.println(new Smartphone("Aster"));
    System.out.println(new Smartphone("Aster", 16000, 256));
    System.out.println(new Smartphone("Aster", 21000, 512, true));
  }
}
