package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import semester1.ConsoleOutput;

public class Task1WrapperAndAutoboxingMemory {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    System.out.println("Кеш Integer");
    inspectIntegerCache(new int[] {-128, -50, 0, 127, 128, 500, 2026});
    System.out.println("\nАвтопакування та розпакування");
    demonstrateAutoboxingUnderTheHood();
    System.out.println("\nРозбір телеметрії");
    List<Integer> data = parseTelemetryStream(
        new String[] {"  145 ", "-30", "ERR_404", "980", "", null, "2147483647", "-85"});
    System.out.println(data);
    printExtremesAndStats(data);
  }

  public static void inspectIntegerCache(int[] testValues) {
    System.out.printf("%10s | %5s | %s%n", "Значення", "==", "equals");
    for (int value : testValues) {
      Integer first = Integer.valueOf(value);
      Integer second = Integer.valueOf(value);
      System.out.printf("%10d | %5b | %b%n", value, first == second, first.equals(second));
    }
  }

  public static void demonstrateAutoboxingUnderTheHood() {
    Integer boxedInt = 42;
    Double boxedDouble = 3.14;
    Boolean boxedBoolean = true;
    int integer = boxedInt;
    double decimal = boxedDouble;
    boolean flag = boxedBoolean;
    System.out.printf("Неявно: %d, %s, %b%n", integer, decimal, flag);
    System.out.printf("Явно: %d, %s, %b%n", Integer.valueOf(42).intValue(),
        Double.valueOf(3.14).doubleValue(), Boolean.valueOf(true).booleanValue());

    List<Integer> readings = Arrays.asList(45, null, -12, 88, null, 102);
    try {
      int reading = readings.get(1);
      System.out.println(reading);
    } catch (NullPointerException e) {
      System.out.println("NullPointerException при розпакуванні null");
    }
    int sum = 0;
    for (Integer reading : readings) {
      if (reading != null) sum += reading;
    }
    System.out.println("Сума без null: " + sum);
  }

  public static List<Integer> parseTelemetryStream(String[] rawPackets) {
    List<Integer> validData = new ArrayList<>();
    for (String packet : rawPackets) {
      if (packet == null) {
        System.out.println("Пропущено пакет: null");
        continue;
      }
      try {
        validData.add(Integer.parseInt(packet.trim()));
      } catch (NumberFormatException e) {
        System.out.printf("Пропущено пакет: «%s»%n", packet);
      }
    }
    return validData;
  }

  public static void printExtremesAndStats(List<Integer> validData) {
    if (validData.isEmpty()) {
      System.out.println("Валідних даних немає");
      return;
    }
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    long sum = 0;
    for (int value : validData) {
      min = Math.min(min, value);
      max = Math.max(max, value);
      sum += value;
    }
    System.out.printf("Мінімум: %d, максимум: %d, сума: %d%n", min, max, sum);

    List<Integer> byIndex = new ArrayList<>(validData);
    int removed = byIndex.remove(0);
    System.out.printf("remove(0) видалив %d: %s%n", removed, byIndex);
    List<Integer> byValue = new ArrayList<>(validData);
    boolean found = byValue.remove(Integer.valueOf(-30));
    System.out.printf("remove(Integer.valueOf(-30)): %b, список: %s%n", found, byValue);
  }
}
