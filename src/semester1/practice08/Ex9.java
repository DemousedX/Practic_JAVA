package semester1.practice08;

public final class Ex9 {
  private Ex9() {}

  static class Employee {
    private String name;
    protected double salary;

    Employee(String name, double salary) {
      this.name = name;
      this.salary = Math.max(0, salary);
    }

    public double getSalary() {
      return salary;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return "Employee{name='" + name + "', salary=" + salary + "}";
    }
  }

  static class Developer extends Employee {
    private String programmingLanguage;

    Developer(String name, double salary, String language) {
      super(name, salary);
      programmingLanguage = language;
    }

    @Override
    public String toString() {
      return "Developer{"
          + getName()
          + ", salary="
          + salary
          + ", language='"
          + programmingLanguage
          + "'}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 09 ---%n");

    System.out.println(new Employee("Олена", 42000));
    System.out.println(new Developer("Іван", 68000, "Java"));
  }
}
