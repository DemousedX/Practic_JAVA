package semester1.practice07;

public class Ex25 {
  static class UserAccount {
    private int id;
    private String username, email;
    private static int nextId = 1001;

    public UserAccount(String username, String email) {
      this.id = nextId++;
      this.username = username;
      this.email = email;
    }

    public static int getNextAvailableId() {
      return nextId;
    }

    public static void resetIdSequence(int startId) {
      nextId = startId;
    }

    public void print() {
      System.out.println(id + " | " + username + " | " + email);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (int i = 1; i <= 3; i++) new UserAccount("user" + i, "user" + i + "@example.com").print();
    System.out.println(UserAccount.getNextAvailableId());
    UserAccount.resetIdSequence(2001);
    System.out.println(UserAccount.getNextAvailableId());
  }
}
