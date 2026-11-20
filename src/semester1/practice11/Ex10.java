package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex10 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    System.out.println(traceArrayListCapacity(100));
  }

  public static List<Integer> traceArrayListCapacity(int elementsCount) {
    List<Integer> capacities = new ArrayList<>();
    long capacity = 0;
    for (long size = 1; size <= elementsCount; size++) {
      if (size > capacity) {
        long previous = capacity;
        capacity = previous == 0 ? 10 : previous + (previous >> 1);
        int current = (int) Math.min(capacity, Integer.MAX_VALUE);
        capacities.add(current);
        System.out.printf("Елемент %d: %d -> %d%n", size, previous, current);
      }
    }
    return capacities;
  }
}
