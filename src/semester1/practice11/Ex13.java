package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex13 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<Integer> speeds = new ArrayList<>(List.of(60, 85, 110, 95, 130));
    System.out.printf("Перша: %d, центральна: %d, остання: %d%n",
        speeds.get(0), speeds.get(speeds.size() / 2), speeds.get(speeds.size() - 1));
    for (int i = 0; i < speeds.size(); i++) {
      if (speeds.get(i) > 100) {
        int old = speeds.set(i, 100);
        System.out.printf("Індекс %d: %d -> 100 км/год%n", i, old);
      }
    }
    System.out.println(speeds);
  }
}
