package semester1.practice07;

public class Ex38 {
  static class Product {
    int id;
    String title;
    double price;

    public Product(int id, String title, double price) {
      this.id = id;
      this.title = title;
      this.price = price;
    }
  }

  static class Customer {
    String name;
    double walletBalance;

    public Customer(String name, double walletBalance) {
      this.name = name;
      this.walletBalance = walletBalance;
    }

    public boolean pay(double amount) {
      if (amount < 0 || amount > walletBalance) return false;
      walletBalance -= amount;
      return true;
    }
  }

  static class Order {
    Customer customer;
    Product[] items;
    int itemCount;
    private boolean paid;

    public Order(Customer customer, int maxItems) {
      this.customer = customer;
      items = new Product[maxItems];
    }

    public void addProduct(Product p) {
      if (!paid && p != null && itemCount < items.length) items[itemCount++] = p;
    }

    public double calculateTotal() {
      double sum = 0;
      for (int i = 0; i < itemCount; i++) sum += items[i].price;
      return sum;
    }

    public boolean checkout() {
      if (paid) return false;
      double total = calculateTotal();
      if (!customer.pay(total)) {
        System.out.println("Недостатньо коштів");
        return false;
      }
      paid = true;
      System.out.println("Покупець: " + customer.name);
      for (int i = 0; i < itemCount; i++)
        System.out.println(items[i].title + " | " + items[i].price);
      System.out.println("Разом: " + total);
      return true;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (double balance : new double[] {1000, 10}) {
      Order o = new Order(new Customer("Іван", balance), 3);
      o.addProduct(new Product(1, "Книга", 250));
      o.addProduct(new Product(2, "Ручка", 30));
      System.out.println(o.checkout());
    }
  }
}
