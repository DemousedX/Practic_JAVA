package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex22 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    System.out.println(deduplicate(new ArrayList<>(List.of(5, 12, 5, 8, 12, 20, 5))));
    System.out.println(deduplicate(new ArrayList<>(List.of("Java", "SQL", "Java", "Git"))));
  }

  public static <T> ArrayList<T> deduplicate(List<T> source) {
    ArrayList<T> unique = new ArrayList<>();
    for (T item : source) {
      if (!unique.contains(item)) unique.add(item);
    }
    return unique;
  }
}
