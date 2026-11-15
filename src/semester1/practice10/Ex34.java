package semester1.practice10;

public class Ex34 {

  abstract static class AbstractSecurityProtocol {
    protected abstract boolean authenticateUser(String token);

    protected abstract String executePayload(String command);

    public final String runSecureCommand(String token, String command) {
      if (token == null || !authenticateUser(token)) return "403 FORBIDDEN";
      return "[AUDITED] " + executePayload(command);
    }
  }

  static class JwtSecurityProtocol extends AbstractSecurityProtocol {
    @Override
    protected boolean authenticateUser(String token) {
      return "demo-jwt".equals(token);
    }

    @Override
    protected String executePayload(String command) {
      return "JWT: " + command;
    }
  }

  static class ApiKeySecurityProtocol extends AbstractSecurityProtocol {
    @Override
    protected boolean authenticateUser(String token) {
      return "demo-api-key".equals(token);
    }

    @Override
    protected String executePayload(String command) {
      return "API: " + command;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    AbstractSecurityProtocol[] protocols = {
      new JwtSecurityProtocol(), new ApiKeySecurityProtocol()
    };
    String[] tokens = {"demo-jwt", "demo-api-key"};
    for (int i = 0; i < protocols.length; i++) {
      System.out.println(protocols[i].runSecureCommand(null, "status"));
      System.out.println(protocols[i].runSecureCommand("wrong", "status"));
      System.out.println(protocols[i].runSecureCommand(tokens[i], "status"));
    }
    // Перевірка умовного токена імітує автентифікацію в навчальному прикладі

  }
}
