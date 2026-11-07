package semester1.practice08;

public final class Ex13 {
  private Ex13() {}

  static class Person {
    private String fullName;
    private int birthYear;

    Person(String fullName, int birthYear) {
      this.fullName = fullName;
      this.birthYear = birthYear;
    }

    public int getAge(int year) {
      return Math.max(0, year - birthYear);
    }

    @Override
    public String toString() {
      return "Person{" + fullName + ", age=" + getAge(2026) + "}";
    }
  }

  static class UniversityStudent extends Person {
    private String studentId, major;
    private int scholarship;

    UniversityStudent(String name, int birth, String id, String major, int scholarship) {
      super(name, birth);
      studentId = id;
      this.major = major;
      this.scholarship = scholarship;
    }

    @Override
    public String toString() {
      return "UniversityStudent{"
          + super.toString()
          + ", id="
          + studentId
          + ", major="
          + major
          + ", scholarship="
          + scholarship
          + "}";
    }
  }

  static class Professor extends Person {
    private String title;
    private int publications;

    Professor(String name, int birth, String title, int publications) {
      super(name, birth);
      this.title = title;
      this.publications = publications;
    }

    @Override
    public String toString() {
      return "Professor{"
          + super.toString()
          + ", title="
          + title
          + ", publications="
          + publications
          + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 13 ---%n");

    System.out.println(
        new UniversityStudent("Олена Коваль", 2004, "ST-25", "Computer Science", 2500));
    System.out.println(new Professor("Іван Мельник", 1970, "Associate Professor", 32));
  }
}
