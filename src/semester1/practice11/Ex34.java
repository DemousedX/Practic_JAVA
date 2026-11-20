package semester1.practice11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex34 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<Integer> numbers = new ArrayList<>(List.of(1, -5, 8, 3, 6, 12, 9, 0, 4, 15));
    System.out.println("До видалення: " + numbers);
    System.out.println("Видалено з діапазону [3; 9]: " + removeInRange(numbers, 3, 9));
    System.out.println("Після видалення: " + numbers);
  }

  public static int removeInRange(List<Integer> list, int min, int max) {
    int removed = 0;
    Iterator<Integer> it = list.iterator();
    while (it.hasNext()) {
      int number = it.next();
      if (number >= min && number <= max) {
        it.remove();
        removed++;
      }
    }
    return removed;
  }
}
