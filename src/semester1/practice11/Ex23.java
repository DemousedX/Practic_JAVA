package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex23 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<String> listA = List.of("Іван", "Анна", "Богдан");
    List<String> listB = List.of("Анна", "Богдан", "Олена");
    System.out.println("Обидва іспити: " + intersection(listA, listB));
    System.out.println("Лише Java: " + difference(listA, listB));
  }

  public static List<String> intersection(List<String> first, List<String> second) {
    List<String> result = new ArrayList<>(first);
    result.retainAll(second);
    return result;
  }

  public static List<String> difference(List<String> first, List<String> second) {
    List<String> result = new ArrayList<>(first);
    result.removeAll(second);
    return result;
  }
}
