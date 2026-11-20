package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex21 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    manageTaskList();
  }

  public static void manageTaskList() {
    ArrayList<String> tasks = new ArrayList<>();
    System.out.println("Список порожній: " + tasks.isEmpty());
    for (String task : List.of("Збірка", "Тести", "Огляд", "Документація", "Випуск")) {
      tasks.add(task);
    }
    tasks.add(0, "Термінове виправлення");
    System.out.println("Завдання 0: " + tasks.get(0));
    tasks.set(0, "Перевірка виправлення");
    System.out.println("Є тести: " + tasks.contains("Тести"));
    tasks.remove("Збірка");
    tasks.remove(0);
    System.out.printf("Залишилось: %d, експорт: %s%n", tasks.size(), Arrays.toString(tasks.toArray()));
    tasks.clear();
    System.out.println("Після очищення: " + tasks);
  }
}
