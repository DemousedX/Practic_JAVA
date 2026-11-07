package semester1.practice09;

public final class Ex27 {
  private Ex27() {}

  abstract static class AbstractEmployee {
    private final int id;
    private final String name;
    protected double taxRate;

    AbstractEmployee(int id, String n, double t) {
      this.id = id;
      name = n;
      taxRate = Math.max(0, Math.min(1, t));
    }

    public abstract double calculateGrossSalary();

    public final double calculateNetSalary() {
      return calculateGrossSalary() * (1 - taxRate);
    }

    public String toString() {
      return id
          + " "
          + name
          + ": calculateGrossSalary="
          + calculateGrossSalary()
          + ", calculateNetSalary="
          + calculateNetSalary();
    }
  }

  static final class SalariedEmployee extends AbstractEmployee {
    private final double monthlySalary, bonus;

    SalariedEmployee(int i, String n, double t, double s, double b) {
      super(i, n, t);
      monthlySalary = s;
      bonus = b;
    }

    public double calculateGrossSalary() {
      return monthlySalary + bonus;
    }
  }

  static final class HourlyContractor extends AbstractEmployee {
    private final int hoursWorked;
    private final double hourlyRate;

    HourlyContractor(int i, String n, double t, int h, double r) {
      super(i, n, t);
      hoursWorked = h;
      hourlyRate = r;
    }

    public double calculateGrossSalary() {
      return Math.min(160, hoursWorked) * hourlyRate
          + Math.max(0, hoursWorked - 160) * hourlyRate * 1.5;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new SalariedEmployee(1, "Олена", .195, 45000, 3000));
    System.out.println(new HourlyContractor(2, "Іван", .195, 180, 400));
  }
}
