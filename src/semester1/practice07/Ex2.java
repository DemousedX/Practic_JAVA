package semester1.practice07;

public class Ex2 {
  static class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
      this.name = name;
      this.age = age < 15 || age > 80 ? 18 : age;
      this.gpa = gpa < 0 || gpa > 5 ? 0 : gpa;
    }

    public boolean isHonorStudent() {
      return gpa >= 4.5;
    }

    public void printStudent() {
      System.out.printf(
          "%s | %d | %.2f | %s%n",
          name, age, gpa, isHonorStudent() ? "Відмінник" : "Звичайний студент");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new Student("Олександр", 18, 4.7).printStudent();
    new Student("Іван", 10, 7).printStudent();
  }
}
