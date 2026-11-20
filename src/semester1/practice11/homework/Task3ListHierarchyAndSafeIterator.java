package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import semester1.ConsoleOutput;

public class Task3ListHierarchyAndSafeIterator {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<String> rawLogs = Arrays.asList("INFO: Auth OK", "CORRUPTED_PACKET_01",
        "  ERROR: DB Timeout  ", "DEBUG: Ping", "CORRUPTED_PACKET_02", null,
        "ERROR: Disk Full", "INFO: Logout");
    List<String> arrayLogs = new ArrayList<>(rawLogs);
    List<String> linkedLogs = new LinkedList<>(rawLogs);

    System.out.println("Сирі логи: " + rawLogs);
    demonstrateFailFastCrash(new ArrayList<>(rawLogs));
    List<String> reversedArray = processLogs(arrayLogs);
    List<String> reversedLinked = processLogs(linkedLogs);
    System.out.println("Обидва списки дають однаковий результат: "
        + (arrayLogs.equals(linkedLogs) && reversedArray.equals(reversedLinked)));
  }

  public static void demonstrateFailFastCrash(List<String> logs) {
    try {
      for (String log : logs) {
        if (log != null && log.contains("CORRUPTED")) logs.remove(log);
      }
    } catch (ConcurrentModificationException e) {
      System.out.println("ConcurrentModificationException: modCount != expectedModCount");
    }
  }

  public static int purgeLogsByKeywordSafely(List<String> logs, String keyword) {
    int removed = 0;
    Iterator<String> it = logs.iterator();
    while (it.hasNext()) {
      String log = it.next();
      if (log == null || log.isBlank() || log.contains(keyword)) {
        it.remove();
        removed++;
      }
    }
    return removed;
  }

  public static void enrichCriticalLogsWithListIterator(List<String> logs) {
    ListIterator<String> listIt = logs.listIterator();
    while (listIt.hasNext()) {
      String trimmed = listIt.next().trim();
      listIt.set(trimmed);
      if (trimmed.startsWith("ERROR:")) listIt.add("[ALERT-TRIGGERED]");
    }
  }

  public static List<String> collectReverseOrder(List<String> logs) {
    List<String> reversed = new ArrayList<>(logs.size());
    ListIterator<String> listIt = logs.listIterator(logs.size());
    while (listIt.hasPrevious()) reversed.add(listIt.previous());
    return reversed;
  }

  private static List<String> processLogs(List<String> logs) {
    System.out.printf("%n%s: видалено %d записів%n", logs.getClass().getSimpleName(),
        purgeLogsByKeywordSafely(logs, "CORRUPTED"));
    enrichCriticalLogsWithListIterator(logs);
    System.out.println("З маркерами: " + logs);
    List<String> reversed = collectReverseOrder(logs);
    System.out.println("У зворотному порядку: " + reversed);
    return reversed;
  }
}
