package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex1 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    demonstrateWrapperTwins();
  }

  public static void demonstrateWrapperTwins() {
    Object[] wrappers = {
      Byte.valueOf((byte) 8), Short.valueOf((short) 16), Integer.valueOf(32), Long.valueOf(64L),
      Float.valueOf(3.5f), Double.valueOf(3.14), Character.valueOf('J'), Boolean.valueOf(true)
    };
    for (Object wrapper : wrappers) {
      System.out.printf("%s: %s%n", wrapper.getClass().getSimpleName(), wrapper);
    }
    // ArrayList<int> не компілюється: параметр типу має бути посилальним.
    ArrayList<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
    System.out.println("ArrayList<Integer>: " + numbers);
  }
}
