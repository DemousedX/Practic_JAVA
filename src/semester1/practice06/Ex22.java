package semester1.practice06;

public class Ex22 {
  static class Employee {
    String name;
    double baseSalary, bonusPercentage;

    public double calculateTotalSalary() {
      return baseSalary * (1 + bonusPercentage / 100);
    }

    public double calculateTax() {
      return calculateTotalSalary() * 0.195;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Employee e = new Employee();
    e.name = "Олександр";
    e.baseSalary = 30000;
    e.bonusPercentage = 15;
    System.out.println(
        e.name + " | зарплата " + e.calculateTotalSalary() + " | податок " + e.calculateTax());
  }
}
