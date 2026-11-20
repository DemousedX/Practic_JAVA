package semester1.practice11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import semester1.ConsoleOutput;

public class Ex28 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<List<String>> lists = List.of(new ArrayList<>(), new LinkedList<>(), new Vector<>(), new Stack<>());
    for (List<String> list : lists) {
      list.addAll(List.of("Java", "SQL", "Git"));
      System.out.println(list.getClass().getSimpleName());
      printElements(list);
      printSummary(list);
      getFirstAndLast(list);
    }
  }

  public static <E> void printElements(Iterable<E> iterable) {
    Iterator<E> iterator = iterable.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  public static <E> void printSummary(Collection<E> collection) {
    System.out.printf("Розмір: %d, порожня: %s%n", collection.size(), collection.isEmpty());
  }

  public static <E> E getFirstAndLast(List<E> list) {
    if (list.isEmpty()) {
      System.out.println("Список порожній");
      return null;
    }
    E last = list.get(list.size() - 1);
    System.out.printf("Перший: %s, останній: %s%n", list.get(0), last);
    return last;
  }
}
