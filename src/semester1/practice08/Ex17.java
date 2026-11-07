package semester1.practice08;

public class Ex17 {
  static class StaffMember {
    String name;
    double baseSalary;

    public StaffMember(String name, double baseSalary) {
      this.name = name;
      this.baseSalary = baseSalary;
    }

    public double calculateMonthlyPay() {
      return baseSalary;
    }

    public String toString() {
      return name + " | ставка: " + baseSalary + " | до виплати: " + calculateMonthlyPay();
    }
  }

  static class Manager extends StaffMember {
    double teamBonus;

    public Manager(String name, double baseSalary, double teamBonus) {
      super(name, baseSalary);
      this.teamBonus = teamBonus;
    }

    @Override
    public double calculateMonthlyPay() {
      return super.calculateMonthlyPay() + teamBonus;
    }

    @Override
    public String toString() {
      return "Manager{" + super.toString() + ", bonus=" + teamBonus + "}";
    }
  }

  static class SalesPerson extends StaffMember {
    double salesVolume, commissionRate;

    public SalesPerson(String name, double baseSalary, double salesVolume, double commissionRate) {
      super(name, baseSalary);
      this.salesVolume = salesVolume;
      this.commissionRate = commissionRate;
    }

    @Override
    public double calculateMonthlyPay() {
      return super.calculateMonthlyPay() + salesVolume * (commissionRate / 100);
    }

    @Override
    public String toString() {
      return "SalesPerson{"
          + super.toString()
          + ", sales="
          + salesVolume
          + ", commission="
          + commissionRate
          + "%}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new StaffMember("Іван", 20000));
    System.out.println(new Manager("Марія", 40000, 8000));
    System.out.println(new SalesPerson("Андрій", 20000, 150000, 4));
  }
}
