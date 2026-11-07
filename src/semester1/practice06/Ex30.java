package semester1.practice06;

public class Ex30 {
  static class Person {
    private String name;
    private int age;

    public void setName(String name) {
      this.name = name;
    }

    public void setAge(int age) {
      if (age >= 0 && age <= 120) this.age = age;
    }

    public void printSummary() {
      System.out.println(name + ", " + age);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Person a = new Person(), b = new Person();
    a.setName("Іван");
    a.setAge(19);
    b.setName("Олена");
    b.setAge(20);
    a.printSummary();
    b.printSummary();
  }
}
