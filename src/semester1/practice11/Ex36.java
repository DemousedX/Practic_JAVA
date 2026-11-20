package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex36 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    String[] result = mergeUniqueToArray(List.of("Java", "SQL", "Java"), List.of("SQL", "Git", "Linux"));
    System.out.println(Arrays.toString(result));
  }

  public static String[] mergeUniqueToArray(List<String> first, List<String> second) {
    var merged = new ArrayList<String>();
    for (String item : first) {
      if (!merged.contains(item)) merged.add(item);
    }
    for (String item : second) {
      if (!merged.contains(item)) merged.add(item);
    }
    return merged.toArray(new String[0]);
  }
}
