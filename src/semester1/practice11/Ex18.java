package semester1.practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import semester1.ConsoleOutput;

public class Ex18 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<String> langs = new ArrayList<>(List.of("Java", "Python", "C++", "Java", "Kotlin", "Java"));
    System.out.printf("Kotlin: %s, Rust: %s%n", langs.contains("Kotlin"), langs.contains("Rust"));
    System.out.printf("Java: перший індекс %d, останній %d, кількість %d%n",
        langs.indexOf("Java"), langs.lastIndexOf("Java"), countOccurrences(langs, "Java"));
  }

  public static int countOccurrences(List<String> list, String target) {
    int count = 0;
    for (String item : list) {
      if (Objects.equals(item, target)) count++;
    }
    return count;
  }
}
