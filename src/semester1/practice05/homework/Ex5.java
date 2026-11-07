package semester1.practice05.homework;

import java.util.Arrays;
import java.util.Scanner;

public final class Ex5 {
  private Ex5() {}

  private static void pets(Scanner s) {
    String[] names = {"Dog", "Cat", "Dragon", "Unicorn", "Huge Titanic Cat"};
    int[] power = {15, 25, 120, 350, 2000};
    double[] chance = {45, 30, 15, 8, 2};
    String[] inv = new String[8];
    int[] strength = new int[8];
    int count = 0, coins = 300;
    while (true) {
      System.out.printf("Монети %d | слоти %d/8 | 1 яйце, 2 інвентар, 0 вихід: ", coins, count);
      int op = s.nextInt();
      if (op == 0) break;
      if (op == 2) {
        for (int i = 0; i < count; i++) System.out.println(inv[i] + " (сила " + strength[i] + ")");
        continue;
      }
      if (op != 1) {
        System.out.println("Невідома команда");
        continue;
      }
      if (coins < 100) {
        System.out.println("Не вистачає монет");
        continue;
      }
      if (count == 8) {
        System.out.println("Рюкзак заповнений - спершу звільни слот");
        continue;
      }
      coins -= 100;
      double roll = Math.random() * 100, cumulative = 0;
      int pet = names.length - 1;
      for (int i = 0; i < chance.length; i++) {
        cumulative += chance[i];
        if (roll < cumulative) {
          pet = i;
          break;
        }
      }
      inv[count] = names[pet];
      strength[count++] = power[pet];
      System.out.println("Випав вихованець: " + names[pet] + "; сила " + power[pet]);
    }
    int total = Arrays.stream(strength, 0, count).sum();
    System.out.println(
        "Команда: " + Arrays.toString(Arrays.copyOf(inv, count)) + " | сумарна сила " + total);
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N5, завдання 5 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      pets(s);
    }
  }
}
