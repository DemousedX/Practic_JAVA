package semester1.practice08;

public final class Ex31 {
  private Ex31() {}

  static class User {
    protected int id;
    protected String email;

    User(int id, String email) {
      this.id = id;
      this.email = email;
    }

    @Override
    public String toString() {
      return "User{id=" + id + ", email='" + email + "'}";
    }
  }

  static class StudentUser extends User {
    protected String groupCode;
    protected double gpa;

    StudentUser(int id, String email, String group, double gpa) {
      super(id, email);
      groupCode = group;
      this.gpa = gpa;
    }

    @Override
    public String toString() {
      return "StudentUser{" + super.toString() + ", group='" + groupCode + "', GPA=" + gpa + "}";
    }
  }

  static class PostgraduateStudent extends StudentUser {
    private String thesisTopic, supervisorName;

    PostgraduateStudent(
        int id, String email, String group, double gpa, String topic, String supervisor) {
      super(id, email, group, gpa);
      thesisTopic = topic;
      supervisorName = supervisor;
    }

    public boolean canDefend() {
      return gpa >= 85 && !thesisTopic.isBlank();
    }

    @Override
    public String toString() {
      return "PostgraduateStudent{"
          + super.toString()
          + ", topic='"
          + thesisTopic
          + "', supervisor='"
          + supervisorName
          + "', canDefend="
          + canDefend()
          + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 31 ---%n");

    System.out.println(
        new PostgraduateStudent(
            101, "student@example.com", "KN-11", 91.2, "Secure Java apps", "І. Петренко"));
  }
}
