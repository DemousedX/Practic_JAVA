package semester1.practice10;

public class Ex4 {

  static class NotificationSender {
    private final String recipient;

    NotificationSender(String recipient) {
      this.recipient = recipient;
    }

    public String send(String message) {
      return recipient + ": " + message;
    }
  }

  static class EmailSender extends NotificationSender {
    EmailSender(String recipient) {
      super(recipient);
    }

    @Override
    public String send(String message) {
      return super.send("Тема: Тривога | " + message);
    }
  }

  static class SmsSender extends NotificationSender {
    SmsSender(String recipient) {
      super(recipient);
    }

    @Override
    public String send(String message) {
      return super.send(message.substring(0, Math.min(70, message.length())));
    }
  }

  static class TelegramBotSender extends NotificationSender {
    TelegramBotSender(String recipient) {
      super(recipient);
    }

    @Override
    public String send(String message) {
      return super.send("⚠ **" + message + "**");
    }
  }

  public static void broadcastAlert(NotificationSender[] senders, String alertText) {
    for (NotificationSender s : senders) System.out.println(s.send(alertText));
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    broadcastAlert(
        new NotificationSender[] {
          new EmailSender("student@example.com"),
          new SmsSender("Тестовий номер"),
          new TelegramBotSender("Навчальний чат")
        },
        "Увага! Перевірте повідомлення системи та перейдіть до безпечного місця згідно з"
            + " інструкцією");
  }
}
