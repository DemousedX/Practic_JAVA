package semester1.practice05.homework;

import java.util.Arrays;

public final class Ex4 {
  private Ex4() {}

  private static void dota() {
    String[] heroes = {"Pudge", "Invoker", "Juggernaut", "Crystal Maiden", "Earthshaker"};
    int[] k = {8, 12, 10, 2, 4},
        d = {6, 3, 2, 9, 5},
        a = {14, 9, 8, 18, 16},
        gold = {14500, 21200, 24800, 9800, 12300};
    int kills = Arrays.stream(k).sum(), goldSum = Arrays.stream(gold).sum(), mvp = 0;
    double best = -1;
    for (int i = 0; i < 5; i++) {
      double kda = (double) (k[i] + a[i]) / Math.max(1, d[i]);
      if (kda > best) {
        best = kda;
        mvp = i;
      }
      System.out.printf(
          "%-18s K/D/A %d/%d/%d KDA %.2f KP %.1f%% Net Worth %d%n",
          heroes[i],
          k[i],
          d[i],
          a[i],
          kda,
          kills == 0 ? 0 : 100.0 * (k[i] + a[i]) / kills,
          gold[i]);
    }
    System.out.println(
        "Командні вбивства: " + kills + ", Net Worth: " + goldSum + ", MVP: " + heroes[mvp]);
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N5, завдання 4 ---%n");
    dota();
  }
}
