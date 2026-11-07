package semester1.practice06;

public class Ex25 {
  static class SecretVault {
    private String secretCode = "Pass123";

    public boolean verifyCode(String attempt) {
      return secretCode.equals(attempt);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    SecretVault v = new SecretVault();
    System.out.println(v.verifyCode("hacked"));
    System.out.println(v.verifyCode("Pass123"));
  }
}
