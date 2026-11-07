package semester1.practice07;

public class Ex18 {
  static class DocumentPrinter {
    public void print(String message) {
      System.out.println(message);
    }

    public void print(int number) {
      System.out.println("[INT]: " + number);
    }

    public void print(double number, int decimals) {
      if (decimals < 0) throw new IllegalArgumentException("Кількість знаків має бути невід'ємною");
      System.out.println(String.format("%." + decimals + "f", number));
    }

    public void print(String[] lines) {
      for (int i = 0; i < lines.length; i++) System.out.println((i + 1) + ": " + lines[i]);
    }

    public void print(String message, boolean uppercase) {
      System.out.println(uppercase ? message.toUpperCase() : message);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    DocumentPrinter p = new DocumentPrinter();
    p.print("Звіт");
    p.print(123);
    p.print(3.14159, 3);
    p.print(new String[] {"Перший", "Другий"});
    p.print("Java", true);
  }
}
