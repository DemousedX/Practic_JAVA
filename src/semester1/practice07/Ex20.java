package semester1.practice07;

public class Ex20 {
  static class Logger {
    public void log(String message) {
      log("INFO", message);
    }

    public void log(String level, String message) {
      System.out.println("[" + level + "] " + message);
    }

    public void log(String level, int errorCode, String message) {
      System.out.println("[" + level + "] (Code: " + errorCode + "): " + message);
    }

    public void log(String tag, String message, boolean timestamp) {
      System.out.println(
          (timestamp ? System.currentTimeMillis() + " " : "") + "[" + tag + "] " + message);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Logger l = new Logger();
    l.log("Запуск");
    l.log("WARN", "Низький баланс");
    l.log("ERROR", 404, "Файл не знайдено");
    l.log("APP", "Завершення", true);
  }
}
