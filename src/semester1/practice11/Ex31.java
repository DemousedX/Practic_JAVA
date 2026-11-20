package semester1.practice11;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex31 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<Integer> data = new ArrayList<>(List.of(15, -3, 42, -10, 8, -1, 25));
    try {
      ArrayList<Integer> unsafe = new ArrayList<>(data);
      for (Integer x : unsafe) {
        if (x < 0) unsafe.remove(x);
      }
    } catch (ConcurrentModificationException e) {
      System.out.println("ConcurrentModificationException: список змінено в обхід ітератора");
    }
    removeNegativesWithIterator(data);
    System.out.println("Очищений список: " + data);
  }

  public static void removeNegativesWithIterator(List<Integer> list) {
    Iterator<Integer> it = list.iterator();
    while (it.hasNext()) {
      if (it.next() < 0) it.remove();
    }
  }
}
