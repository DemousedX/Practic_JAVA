package semester1.practice11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex30 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<String> modules = new ArrayList<>(List.of("Core Java", "OOP", "Collections", "Streams", "Multithreading"));
    Iterator<String> it = modules.iterator();
    int length = 0;
    while (it.hasNext()) {
      String module = it.next();
      System.out.println(module);
      length += module.length();
    }
    System.out.println("Усього символів: " + length);
  }
}
