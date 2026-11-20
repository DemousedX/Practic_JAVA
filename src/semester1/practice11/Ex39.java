package semester1.practice11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import semester1.ConsoleOutput;

public class Ex39 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    System.out.println("Вставки на початок і читання із середини: по 20 000 операцій");
    measure("ArrayList", new ArrayList<>());
    measure("LinkedList", new LinkedList<>());
    System.out.println("Вставка в ArrayList зсуває елементи масиву через System.arraycopy.");
    System.out.println("get у ArrayList звертається до комірки напряму, а LinkedList обходить вузли.");
  }

  private static final int OPERATIONS = 20_000;

  private static void measure(String name, List<Integer> list) {
    long start = System.nanoTime();
    for (int i = 0; i < OPERATIONS; i++) list.add(0, i);
    long insertNanos = System.nanoTime() - start;

    int middle = list.size() / 2;
    long checksum = 0;
    start = System.nanoTime();
    for (int i = 0; i < OPERATIONS; i++) checksum += list.get(middle);
    long readNanos = System.nanoTime() - start;

    System.out.printf(Locale.ROOT, "%s: вставка %.3f мс, читання %.3f мс, контрольна сума %d%n",
        name, insertNanos / 1_000_000.0, readNanos / 1_000_000.0, checksum);
  }
}
