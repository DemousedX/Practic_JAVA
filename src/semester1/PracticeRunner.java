// Цей клас допоможе вам перевірити результат задач всієї практичної
// запускаєте любий клас від PracticeN, він виведе всі результати

package semester1;

import java.io.IOException;

public final class PracticeRunner {
  private PracticeRunner() {}

  public static void run(int practice, int taskCount, String[] args) {
    run(practice, taskCount, 0, args);
  }

  public static void run(int practice, int taskCount, int blockSize, String[] args) {
    ConsoleOutput.useUtf8();
    int first = 1;
    int last = taskCount;
    if (args.length > 0) {
      int task = parseTask(args);
      if (task < 1 || task > taskCount) {
        System.out.printf("Вкажіть один номер завдання від 1 до %d%n", taskCount);
        return;
      }
      first = task;
      last = task;
    }

    System.out.printf("Практична робота №%d%n", practice);
    try {
      for (int task = first; task <= last; task++) {
        if (args.length == 0 && blockSize > 0 && (task - 1) % blockSize == 0) {
          System.out.printf("%nБлок %d%n", (task - 1) / blockSize + 1);
        }
        System.out.printf("%n── Завдання %d ──%n", task);
        String className = "semester1.practice%02d.Ex%d".formatted(practice, task);
        int exitCode = ExerciseProcess.run(className);
        if (exitCode != 0) {
          System.out.printf("Завдання %d завершилося з кодом %d%n", task, exitCode);
        }
      }
    } catch (IOException e) {
      System.out.println("Не вдалося запустити завдання: " + e.getMessage());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("Очікування завершення завдання перервано");
    }
  }

  private static int parseTask(String[] args) {
    if (args.length != 1) return -1;
    try {
      return Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      return -1;
    }
  }
}
