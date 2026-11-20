package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex35 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<String> topics = new ArrayList<>(List.of("Java", "SQL", "Git", "Linux", "Maven"));
    System.out.println("До: " + topics);
    reverseInPlace(topics);
    System.out.println("Після: " + topics);
  }

  public static <T> void reverseInPlace(List<T> list) {
    int size = list.size();
    for (int i = 0; i < size / 2; i++) {
      int other = size - 1 - i;
      T left = list.get(i);
      list.set(i, list.get(other));
      list.set(other, left);
    }
  }
}
