package semester1.practice06;

public class Ex1 {
  static class Student {
    public String name;
    public int age;
    public double gpa;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Student s1 = new Student();
    s1.name = "Денис";
    s1.age = 19;
    s1.gpa = 4.75;
    System.out.println(s1.name + ", " + s1.age + ", " + s1.gpa);
  }
}
