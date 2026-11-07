package semester1.practice08;

public final class Ex28 {
  private Ex28() {}

  static class SecurityTerminal {
    public final String generateAuthHash(String user) {
      return "AUTH-SHA-" + user.toUpperCase();
    }

    public String getWelcomeBanner() {
      return "Secure terminal";
    }
  }

  static class CustomTerminal extends SecurityTerminal {
    @Override
    public String getWelcomeBanner() {
      return super.getWelcomeBanner() + " - welcome";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 28 ---%n");

    CustomTerminal terminal = new CustomTerminal();
    System.out.println(terminal.getWelcomeBanner());
    System.out.println(terminal.generateAuthHash("student"));
  }
}
