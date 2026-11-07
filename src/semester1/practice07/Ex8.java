package semester1.practice07;

public class Ex8 {
  static class Employee {
    private int id;
    private String fullName, position;
    private double monthlySalary;

    public Employee(int id, String fullName, String position, double monthlySalary) {
      this.id = id;
      this.fullName = fullName;
      this.position = position;
      this.monthlySalary = monthlySalary;
    }

    public void raiseSalary(double percent) {
      if (percent > 0) monthlySalary *= 1 + percent / 100;
    }

    public double getAnnualSalary() {
      return monthlySalary * 12;
    }

    public void printBadge() {
      System.out.printf("%d | %s | %s | %.2f грн%n", id, fullName, position, monthlySalary);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Employee e = new Employee(1, "Олена Коваль", "Програміст", 30000);
    e.printBadge();
    e.raiseSalary(15);
    e.printBadge();
    System.out.println(e.getAnnualSalary());
  }
}
