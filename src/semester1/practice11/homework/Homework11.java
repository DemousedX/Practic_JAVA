package semester1.practice11.homework;

import java.io.IOException;
import semester1.ConsoleOutput;
import semester1.ExerciseProcess;

public class Homework11 {
  private static final Class<?>[] TASKS = {
    Task1WrapperAndAutoboxingMemory.class,
    Task2ArrayListCapacityAndDynamicGrowth.class,
    Task3ListHierarchyAndSafeIterator.class,
    Task4ArrayListVsLinkedListPerformance.class,
    Task5StalkerBackpackAndSidorovichLoot.class
  };

  public static String taskClassName(int task) {
    return TASKS[task - 1].getName();
  }

  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    int task = 0;
    if (args.length == 1) {
      try {
        task = Integer.parseInt(args[0]);
      } catch (NumberFormatException e) {
        System.out.println("Вкажіть цілий номер від 1 до 5");
        return;
      }
    }
    if (task < 1 || task > TASKS.length) {
      System.out.println("Вкажіть номер завдання від 1 до 5");
      return;
    }

    try {
      int exitCode = ExerciseProcess.run(taskClassName(task));
      if (exitCode != 0) System.out.println("Завдання завершилося з кодом " + exitCode);
    } catch (IOException e) {
      System.out.println("Не вдалося запустити завдання: " + e.getMessage());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("Очікування завершення завдання перервано");
    }
  }
}
