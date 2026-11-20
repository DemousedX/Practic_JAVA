package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex25 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    demonstrateTypeInference();
  }

  public static void demonstrateTypeInference() {
    List<Integer> list1 = new ArrayList<>();
    var list2 = new ArrayList<Integer>();
    var names = new ArrayList<String>(List.of("Анна", "Богдан"));
    list1.add(10);
    list2.add(20);
    names.add("Олена");
    // list1.add("Java"), list2.add(true) та names.add(5) не компілюються.
    Integer first = list1.get(0);
    Integer second = list2.get(0);
    String name = names.get(2);
    System.out.printf("Integer: %d і %d, String: %s%n", first, second, name);
    System.out.println(names);
  }
}
