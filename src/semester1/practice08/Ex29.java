package semester1.practice08;

public final class Ex29 {
  private Ex29() {}

  public static final class ImmutableServerCredentials {
    private final String host, apiKey;
    private final int port;

    ImmutableServerCredentials(String host, int port, String apiKey) {
      this.host = host;
      this.port = port;
      this.apiKey = apiKey;
    }

    public String getApiKey() {
      return apiKey;
    }

    public String getHost() {
      return host;
    }

    public int getPort() {
      return port;
    }

    @Override
    public String toString() {
      return "ImmutableServerCredentials{host='"
          + host
          + "', port="
          + port
          + ", apiKey='***SECRET***'}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 29 ---%n");

    System.out.println(new ImmutableServerCredentials("api.example.com", 443, "secret-value"));
  }
}
