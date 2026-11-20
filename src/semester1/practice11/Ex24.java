package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import semester1.ConsoleOutput;

public class Ex24 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<String> statuses = new ArrayList<>(Arrays.asList("У черзі", "Готово", "У черзі", null));
    int replaced = replaceAllValues(statuses, "У черзі", "У роботі");
    System.out.printf("Замінено: %d, результат: %s%n", replaced, statuses);
  }

  public static int replaceAllValues(List<String> list, String oldValue, String newValue) {
    int replaced = 0;
    for (int i = 0; i < list.size(); i++) {
      if (Objects.equals(list.get(i), oldValue)) {
        list.set(i, newValue);
        replaced++;
      }
    }
    return replaced;
  }
}
