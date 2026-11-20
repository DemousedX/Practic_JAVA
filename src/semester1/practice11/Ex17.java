package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex17 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 1, 40, 2));
    System.out.println("До видалення: " + numbers);
    int removed = numbers.remove(1);
    System.out.printf("За індексом 1 видалено %d: %s%n", removed, numbers);
    numbers.remove(Integer.valueOf(1));
    numbers.remove(Integer.valueOf(2));
    System.out.println("Після видалення значень 1 і 2: " + numbers);
  }
}
