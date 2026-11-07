package semester1.practice08;

public final class Ex1 {
  private Ex1() {}

  static class Student {
    private String name;
    private int course;
    private double gpa;

    Student(String name, int course, double gpa) {
      setName(name);
      setCourse(course);
      setGpa(gpa);
    }

    public String getName() {
      return name;
    }

    public int getCourse() {
      return course;
    }

    public double getGpa() {
      return gpa;
    }

    public void setName(String value) {
      name = value == null || value.isBlank() ? "Unknown" : value;
    }

    public void setCourse(int value) {
      course = value >= 1 && value <= 6 ? value : 1;
    }

    public void setGpa(double value) {
      gpa = value >= 0 && value <= 100 ? value : 60;
    }

    @Override
    public String toString() {
      return String.format("Student{name='%s', course=%d, gpa=%.2f}", name, course, gpa);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 01 ---%n");

    System.out.println(new Student("Олександр", 2, 91.5));
  }
}
