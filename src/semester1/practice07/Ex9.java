package semester1.practice07;

public class Ex9 {
  static class User {
    private String login, email, role;
    private boolean isActive;

    public User(String login, String email, String role, boolean isActive) {
      this.login = login;
      this.email = email;
      this.role = role;
      this.isActive = isActive;
    }

    public User(String login, String email) {
      this(login, email, "USER", true);
    }

    public User(String login) {
      this(login, login + "@domain.com");
    }

    public User() {
      this("guest");
    }

    public void printProfile() {
      System.out.printf("%s | %s | %s | %s%n", login, email, role, isActive);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new User().printProfile();
    new User("student").printProfile();
    new User("ivan", "ivan@example.com").printProfile();
    new User("admin", "admin@example.com", "ADMIN", false).printProfile();
  }
}
