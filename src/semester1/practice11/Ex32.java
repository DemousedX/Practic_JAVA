package semester1.practice11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import semester1.ConsoleOutput;

public class Ex32 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<String> logs = new ArrayList<>(List.of("INFO: Start", "DEBUG: Init",
        "ERROR: Timeout", "DEBUG: Retry", "INFO: Done"));
    Iterator<String> it = logs.iterator();
    while (it.hasNext()) {
      if (it.next().startsWith("DEBUG:")) it.remove();
    }
    ListIterator<String> listIt = logs.listIterator();
    System.out.println("Прямий обхід:");
    while (listIt.hasNext()) {
      String log = listIt.next();
      if (log.startsWith("ERROR:")) {
        log = "CRITICAL ERROR: Timeout";
        listIt.set(log);
      }
      System.out.println(log);
    }
    System.out.println("Зворотний обхід:");
    while (listIt.hasPrevious()) {
      System.out.println(listIt.previous());
    }
  }
}
