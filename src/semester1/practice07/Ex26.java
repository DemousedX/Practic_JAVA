package semester1.practice07;

public class Ex26 {
  static class ServerConfig {
    public static final String SERVER_NAME = "AlphaEnterprise";
    public static final int MAX_CONNECTIONS = 5;
    private static int activeConnections = 0;

    public static boolean connect() {
      if (activeConnections >= MAX_CONNECTIONS) return false;
      activeConnections++;
      return true;
    }

    public static void disconnect() {
      if (activeConnections > 0) activeConnections--;
    }

    public static void printServerStatus() {
      System.out.println(
          SERVER_NAME
              + ": "
              + activeConnections
              + " активних, "
              + (MAX_CONNECTIONS - activeConnections)
              + " вільних");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (int i = 0; i < 6; i++) System.out.println(ServerConfig.connect());
    ServerConfig.printServerStatus();
    ServerConfig.disconnect();
    ServerConfig.printServerStatus();
  }
}
