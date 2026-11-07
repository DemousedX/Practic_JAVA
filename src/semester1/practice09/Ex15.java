package semester1.practice09;

public class Ex15 {
  static class DeliveryAddress {
    private String city, street;
    private int postOfficeNumber;

    public DeliveryAddress(String city, String street, int postOfficeNumber) {
      this.city = city;
      this.street = street;
      this.postOfficeNumber = postOfficeNumber;
      if (!isValid()) throw new IllegalArgumentException("Некоректна адреса");
    }

    public boolean isValid() {
      return city != null
          && !city.isBlank()
          && street != null
          && !street.isBlank()
          && postOfficeNumber > 0;
    }

    public String toString() {
      return city + ", " + street + ", відділення " + postOfficeNumber;
    }
  }

  static class ParcelOrder {
    private final String orderId;
    private double weightKg;
    private DeliveryAddress destination;
    private boolean shipped;

    public ParcelOrder(String orderId, double weightKg, DeliveryAddress destination) {
      this.orderId = orderId;
      this.weightKg = weightKg;
      this.destination = destination;
    }

    public boolean changeDestination(DeliveryAddress newAddress) {
      if (shipped || newAddress == null || !newAddress.isValid()) return false;
      destination = newAddress;
      return true;
    }

    public void markAsShipped() {
      shipped = true;
    }

    public String toString() {
      return orderId + " | " + weightKg + " kg | " + destination + " | shipped=" + shipped;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ParcelOrder o = new ParcelOrder("ORD1", 2, new DeliveryAddress("Київ", "Хрещатик", 1));
    System.out.println(o.changeDestination(new DeliveryAddress("Львів", "Городоцька", 2)));
    o.markAsShipped();
    System.out.println(o.changeDestination(new DeliveryAddress("Одеса", "Дерибасівська", 3)));
    System.out.println(o);
  }
}
