package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import semester1.ConsoleOutput;

public class Task4ArrayListVsLinkedListPerformance {
  private static final int ELEMENTS = 20_000;

  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    System.out.println("Бенчмарк: по 20 000 вставок для кожного списку");
    compareInsertion("На початок", false);
    compareInsertion("У середину", true);
    System.out.println("Результат конкретного запуску залежить від JVM і комп'ютера.");

    List<Integer> numbers = new ArrayList<>(List.of(45, 12, 89, 3, 22, 67));
    System.out.println("\nДо сортування: " + numbers);
    numbers.sort(null);
    System.out.println("Після сортування: " + numbers);

    List<Integer> part = numbers.subList(1, 4);
    System.out.println("\nsubList(1, 4): " + part);
    part.set(0, 999);
    System.out.println("Базовий список після зміни підсписку: " + numbers);
  }

  private static void compareInsertion(String label, boolean middle) {
    long arrayTime = measureInsertion(new ArrayList<>(), middle);
    long linkedTime = measureInsertion(new LinkedList<>(), middle);
    String result = "однаковий час";
    if (arrayTime < linkedTime) {
      result = "швидша ArrayList";
    } else if (linkedTime < arrayTime) {
      result = "швидша LinkedList";
    }
    System.out.printf(Locale.ROOT, "%s: ArrayList %.3f мс, LinkedList %.3f мс (%s)%n",
        label, arrayTime / 1_000_000.0, linkedTime / 1_000_000.0, result);
  }

  private static long measureInsertion(List<Integer> list, boolean middle) {
    long start = System.nanoTime();
    for (int i = 0; i < ELEMENTS; i++) {
      int index = middle ? list.size() / 2 : 0;
      list.add(index, i);
    }
    return System.nanoTime() - start;
  }
}
