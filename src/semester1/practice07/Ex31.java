package semester1.practice07;

public class Ex31 {
  static class GameSession {
    String sessionToken, hostPlayer;
    boolean isActive;
    private static int activeSessionsCount = 0;
    public static final int MAX_SESSIONS = 3;

    private GameSession(String host) {
      hostPlayer = host;
      sessionToken = java.util.UUID.randomUUID().toString();
      isActive = true;
    }

    public static GameSession createSession(String host) {
      if (activeSessionsCount >= MAX_SESSIONS) {
        System.out.println("Помилка: усі сервери перевантажені!");
        return null;
      }
      GameSession session = new GameSession(host);
      activeSessionsCount++;
      return session;
    }

    public void terminate() {
      if (isActive) {
        isActive = false;
        activeSessionsCount--;
      }
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    GameSession[] a = new GameSession[4];
    for (int i = 0; i < a.length; i++) {
      a[i] = GameSession.createSession("Player" + i);
      System.out.println(a[i] == null ? "null" : a[i].sessionToken);
    }
    a[0].terminate();
    a[0].terminate();
    System.out.println(GameSession.createSession("Player4") != null);
  }
}
