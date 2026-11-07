package semester1.practice06;

public class Ex26 {
  static class UserAccount {
    private String username, password;

    public void setCredentials(String u, String p) {
      username = u;
      password = p;
    }

    public boolean login(String enteredUser, String enteredPass) {
      return username != null && username.equals(enteredUser) && password.equals(enteredPass);
    }

    public void changePassword(String oldPass, String newPass) {
      if (password != null && password.equals(oldPass) && newPass != null) password = newPass;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    UserAccount u = new UserAccount();
    u.setCredentials("student", "pass1");
    System.out.println(u.login("student", "bad"));
    System.out.println(u.login("student", "pass1"));
    u.changePassword("bad", "pass2");
    System.out.println(u.login("student", "pass2"));
    u.changePassword("pass1", "pass2");
    System.out.println(u.login("student", "pass2"));
  }
}
