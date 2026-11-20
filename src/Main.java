import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import semester1.ExerciseProcess;
import semester1.practice11.homework.Homework11;

public class Main {
  private static final FileInputStream RAW_INPUT = new FileInputStream(FileDescriptor.in);
  private static final boolean USE_COLOR = System.getenv("NO_COLOR") == null;
  private static final String CYAN = "\u001B[1;36m";
  private static final String GREEN = "\u001B[1;32m";
  private static final String RESET = "\u001B[0m";
  private static final Work[] PRACTICALS = {
    new Work(1, "Перший проєкт і виведення в консоль", 40),
    new Work(2, "Змінні, типи даних та обчислення", 40),
    new Work(3, "Scanner, умови та логічні оператори", 40),
    new Work(4, "Цикли та приведення типів", 40),
    new Work(5, "Масиви", 40),
    new Work(6, "Вступ до ООП", 40),
    new Work(7, "Конструктори, перевантаження та статичні члени", 40),
    new Work(8, "Інкапсуляція та наслідування", 39),
    new Work(9, "Композиція та абстрактні класи", 39),
    new Work(10, "Поліморфізм та інтерфейси", 39),
    new Work(11, "Обгортки, ArrayList, колекції та ітератори", 40)
  };
  private static final Work[] HOMEWORKS = {
    new Work(2, "Валюта, числа, трикутник, геометрія, RPG", 5),
    new Work(3, "Пальне, доставка, скоринг, Smart Home, квест", 5),
    new Work(4, "Цикли, Fibonacci, прості числа, Brawl Stars", 5),
    new Work(5, "Продажі, склад, кінотеатр, Dota 2, Roblox", 5),
    new Work(6, "Дроби, рівняння, вектори, матриці, Аста", 5),
    new Work(8, "Наслідування та інкапсуляція", 5),
    new Work(9, "Композиція, матриці, кіберімпланти", 5),
    new Work(10, "Поліморфізм, інтерфейси, чисельні методи", 5),
    new Work(11, "Обгортки, списки, ітератори та бенчмарк", 5)
  };

  private record Work(int number, String topic, int taskCount) {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println("Роботи з Java | Олександр Денисенко | КНД-11");
    if (args.length >= 2) {
      launchLegacyHomework(parse(args[0]), parse(args[1]));
      return;
    }

    while (true) {
      System.out.println("\n1 - Практичні роботи (ПЗ)");
      System.out.println("2 - Домашні завдання (ДЗ)");
      System.out.println("0 - Вийти");
      switch (readChoice("Ваш вибір: ")) {
        case 1 -> chooseWork(PRACTICALS, "ПЗ", false);
        case 2 -> chooseWork(HOMEWORKS, "ДЗ", true);
        case 0 -> {
          System.out.println("Роботу завершено");
          return;
        }
        default -> System.out.println("Оберіть 1, 2 або 0");
      }
    }
  }

  private static void chooseWork(Work[] works, String label, boolean homework) {
    while (true) {
      System.out.println();
      for (Work work : works) {
        System.out.printf("%d - %s %02d · %s%n", work.number(), label, work.number(), work.topic());
      }
      System.out.println("0 - До головного меню");

      int number = readChoice("Номер роботи: ");
      if (number == 0) return;
      Work selected =
          Arrays.stream(works).filter(work -> work.number() == number).findFirst().orElse(null);
      if (selected == null) {
        System.out.println("Оберіть номер роботи зі списку");
      } else {
        chooseTask(selected, label, homework);
      }
    }
  }

  private static void chooseTask(Work work, String label, boolean homework) {
    System.out.printf("%n%s %02d · %s%n", label, work.number(), work.topic());
    String prompt = "Номер завдання (1–%d, 0 - до списку робіт): ".formatted(work.taskCount());
    while (true) {
      int task = readChoice(prompt);
      if (task == 0) return;
      if (task < 1 || task > work.taskCount()) {
        System.out.printf("Введіть номер від 1 до %d або 0%n", work.taskCount());
        continue;
      }
      showSource(exerciseClass(work.number(), task, homework));
      printSection(GREEN, "Результат виконання");
      launch(work.number(), task, homework);
      System.out.println();
    }
  }

  private static String exercisePackage(int number, boolean homework) {
    return "semester1.practice%02d%s".formatted(number, homework ? ".homework" : "");
  }

  private static String exerciseClass(int number, int task, boolean homework) {
    if (homework && number == 11) return Homework11.taskClassName(task);
    return exercisePackage(number, homework) + ".Ex" + task;
  }

  private static void showSource(String className) {
    Path source = Path.of("src", className.replace('.', '/') + ".java");
    printSection(CYAN, "Java-код · " + source.getFileName());
    try {
      String code = Files.readString(source, StandardCharsets.UTF_8);
      System.out.print(code);
      if (!code.endsWith("\n")) System.out.println();
    } catch (IOException e) {
      System.out.println("Не вдалося прочитати файл: " + source.toAbsolutePath());
    }
  }

  private static void printSection(String color, String title) {
    System.out.println();
    String heading = "── " + title + " ──";
    System.out.println(USE_COLOR ? color + heading + RESET : heading);
  }

  private static int readChoice(String prompt) {
    while (true) {
      System.out.print(prompt);
      System.out.flush();
      String value = readLine();
      if (value == null) return 0;
      try {
        return Integer.parseInt(value.trim());
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
      if (value == -1 && bytes.size() == 0) return null;
    } catch (IOException e) {
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

  private static void launchLegacyHomework(int menuIndex, int task) {
    if (menuIndex >= 1 && menuIndex <= HOMEWORKS.length) {
      Work work = HOMEWORKS[menuIndex - 1];
      if (task >= 1 && task <= work.taskCount()) {
        launch(work.number(), task, true);
        return;
      }
    }
    System.out.println("Невідоме домашнє завдання або номер задачі");
  }

  private static void launch(int number, int task, boolean homework) {
    String packageName = exercisePackage(number, homework);
    try {
      int exitCode =
          homework && number != 11
              ? ExerciseProcess.run(
                  packageName + ".Homework%02d".formatted(number), Integer.toString(task))
              : ExerciseProcess.run(exerciseClass(number, task, homework));
      if (exitCode != 0) System.out.println("Завдання завершилося з кодом " + exitCode);
    } catch (IOException e) {
      System.out.println("Не вдалося запустити завдання: " + e.getMessage());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("Очікування завершення завдання перервано");
    }
  }
}
