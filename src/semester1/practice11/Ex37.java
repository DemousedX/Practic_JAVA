package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex37 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    System.out.println("До: " + numbers);
    rotateRight(numbers, 2);
    System.out.println("Зсув на 2: " + numbers);
  }

  public static <T> void rotateRight(List<T> list, int k) {
    if (list.isEmpty()) return;
    int shifts = Math.floorMod(k, list.size());
    for (int i = 0; i < shifts; i++) {
      T last = list.remove(list.size() - 1);
      list.add(0, last);
    }
  }
}
