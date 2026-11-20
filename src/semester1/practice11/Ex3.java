package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex3 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    System.out.println(parseNumbersFromStrings(new String[] {"120", "-45", "300", "abc", "1024", ""}));
  }

  public static List<Integer> parseNumbersFromStrings(String[] inputs) {
    List<Integer> numbers = new ArrayList<>();
    int sum = 0;
    for (String input : inputs) {
      try {
        sum += Integer.parseInt(input);
        numbers.add(Integer.valueOf(input));
      } catch (NumberFormatException e) {
        System.out.printf("Пропущено некоректний рядок: «%s»%n", input);
      }
    }
    System.out.println("Сума: " + sum);
    return numbers;
  }
}
