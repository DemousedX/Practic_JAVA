package semester1.practice11;

import java.util.List;

import semester1.ConsoleOutput;

public class Ex4 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    System.out.printf("Integer: %d .. %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
    System.out.printf("Byte: %d .. %d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
    System.out.printf("Short: %d .. %d%n", Short.MIN_VALUE, Short.MAX_VALUE);
    System.out.printf("Long: %d .. %d%n", Long.MIN_VALUE, Long.MAX_VALUE);
    findMinAndMax(List.of(7, -42, 15, 100, -1));
    int number = Integer.MAX_VALUE;
    System.out.println("MAX_VALUE + 1: " + (number + 1));
    if (number == Integer.MAX_VALUE) {
      System.out.println("Додавання 1 виходить за межі типу int");
    }
  }

  public static void findMinAndMax(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      System.out.println("Список порожній");
      return;
    }
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int number : numbers) {
      min = Math.min(min, number);
      max = Math.max(max, number);
    }
    System.out.printf("Мінімум: %d, максимум: %d%n", min, max);
  }
}
