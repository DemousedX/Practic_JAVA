package semester1.practice11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex33 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<Integer> evens = new ArrayList<>();
    List<Integer> odds = new ArrayList<>();
    splitEvenAndOdd(List.of(12, -3, 0, 7, 8, -10, 5), evens, odds);
    printGroup("Парні", evens);
    printGroup("Непарні", odds);
  }

  public static void splitEvenAndOdd(List<Integer> source, List<Integer> evens, List<Integer> odds) {
    Iterator<Integer> it = source.iterator();
    while (it.hasNext()) {
      Integer number = it.next();
      if (number % 2 == 0) {
        evens.add(number);
      } else {
        odds.add(number);
      }
    }
  }

  private static void printGroup(String label, List<Integer> numbers) {
    int maximum = Integer.MIN_VALUE;
    for (int number : numbers) maximum = Math.max(maximum, number);
    System.out.printf("%s: %s, розмір: %d, максимум: %s%n",
        label, numbers, numbers.size(), numbers.isEmpty() ? "немає" : Integer.toString(maximum));
  }
}
