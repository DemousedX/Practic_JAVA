package semester1.practice03;

public class Ex39 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Команда (start/pause/stop/exit): ");
      String command = scanner.nextLine();
      System.out.println("Порівняння посилань через ==: " + (command == "start"));
      System.out.println("Порівняння тексту: " + command.equalsIgnoreCase("start"));
      System.out.println(
          "== порівнює посилання, equalsIgnoreCase порівнює вміст без урахування регістру");
      switch (command.toLowerCase()) {
        case "start" -> System.out.println("Система успішно запущена!");
        case "pause" -> System.out.println("Пауза");
        case "stop" -> System.out.println("Систему зупинено");
        case "exit" -> System.out.println("Вихід");
        default -> System.out.println("Невідома команда");
      }
    }
  }
}
