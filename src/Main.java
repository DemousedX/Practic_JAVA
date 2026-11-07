import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Main {
  private static final FileInputStream RAW_INPUT = new FileInputStream(FileDescriptor.in);
  private static final String[] HOMEWORKS = {
    "",
    "ДЗ до практичної N2 - валюта, числа, трикутник, геометрія, RPG",
    "ДЗ до практичної N3 - пальне, доставка, скоринг, Smart Home, квест",
    "ДЗ до практичної N4 - цикли, Fibonacci, прості числа, Brawl Stars",
    "ДЗ до практичної N5 - продажі, склад, кінотеатр, Dota 2, Roblox",
    "ДЗ до практичної N6 - дроби, рівняння, вектори, матриці, Аста",
    "ДЗ до практичної N8 - наслідування та інкапсуляція",
    "ДЗ до практичної N9 - композиція, матриці, кіберімпланти"
  };

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    printHeader();
    if (args.length >= 2) {
      launch(parse(args[0]), parse(args[1]));
      return;
    }
    while (true) {
      printMenu();
      int homework = read("Оберіть ДЗ (0 - вихід): ");
      if (homework == 0) {
        System.out.println("Роботу завершено");
        return;
      }
      if (homework < 1 || homework >= HOMEWORKS.length) {
        System.out.println("Такого ДЗ немає");
        continue;
      }
      System.out.println(HOMEWORKS[homework]);
      int task = read("Номер завдання (1-5): ");
      if (task < 1 || task > 5) {
        System.out.println("Номер поза межами. Спробуйте ще раз");
        continue;
      }
      launch(homework, task);
      return;
    }
  }

  private static int read(String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = readLine().trim();
      try {
        return Integer.parseInt(value);
      } catch (NumberFormatException e) {
        System.out.println("Введіть ціле число");
      }
    }
  }

  private static String readLine() {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try {
      int value;
      while ((value = RAW_INPUT.read()) != -1 && value != '\n') {
        if (value != '\r') bytes.write(value);
      }
    } catch (java.io.IOException e) {
      throw new IllegalStateException("Не вдалося прочитати вибір меню", e);
    }
    return bytes.toString(StandardCharsets.UTF_8);
  }

  private static int parse(String value) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private static void launch(int homework, int task) {
    if (homework < 1 || homework > 7 || task < 1 || task > 5) {
      System.out.println("Невідоме домашнє завдання або номер задачі");
      return;
    }
    int number = homework < 6 ? homework + 1 : homework + 2;
    String packageName = String.format("semester1.practice%02d.homework", number);
    String className = packageName + ".Homework0" + number;
    try {
      String executable =
          System.getProperty("java.home")
              + "/bin/"
              + (System.getProperty("os.name").toLowerCase().contains("win") ? "java.exe" : "java");
      ProcessBuilder process =
          new ProcessBuilder(
              executable,
              "-Dfile.encoding=UTF-8",
              "-cp",
              System.getProperty("java.class.path"),
              className,
              Integer.toString(task));
      process.inheritIO();
      int exitCode = process.start().waitFor();
      if (exitCode != 0) System.out.println("Завдання завершилося з кодом " + exitCode + ".");
    } catch (Exception e) {
      System.out.println("Не вдалося запустити завдання: " + e.getMessage());
    }
  }

  private static void printHeader() {
    System.out.println("============================================================");
    System.out.println("                    ДОМАШНІ ЗАВДАННЯ З JAVA");
    System.out.println("              Олександр Денисенко | КНД-11");
    System.out.println("============================================================");
  }

  private static void printMenu() {
    System.out.println("\nДОМАШНІ ЗАВДАННЯ:");
    for (int i = 1; i < HOMEWORKS.length; i++) System.out.printf("%2d - %s%n", i, HOMEWORKS[i]);
    System.out.println(" 0 - Вийти");
  }
}
