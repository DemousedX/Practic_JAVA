package semester1.practice06.homework;

import java.util.Scanner;

public final class Ex5 {
  private Ex5() {}

  private static void asta(Scanner s) {
    Asta asta = new Asta();
    int bossHp = 1200, round = 0;
    System.out.println("=== Demoused: Чорний демон проти Патри ===");
    while (bossHp > 0 && asta.isAlive() && round < 30) {
      round++;
      asta.showStatus();
      System.out.printf("Патри HP %d | 1 - меч, 2-5 - навичка, 6 - захист: ", bossHp);
      int action = s.nextInt();
      int damage = 0;
      if (action == 1) damage = asta.basicSwordAttack();
      else if (action >= 2 && action <= 5) damage = asta.useSkill(action - 2);
      else if (action == 6) System.out.println("Аста готується зменшити шкоду");
      else System.out.println("Хід пропущено");
      bossHp = Math.max(0, bossHp - damage);
      if (bossHp > 0) {
        asta.takeDamage(action == 6 ? 80 : 110);
        asta.pushLimits();
      }
    }
    System.out.println(
        bossHp <= 0 ? "Перемога над Патри за " + round + " раундів!" : "Аста вибув із бою");
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N6, завдання 5 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      asta(s);
    }
  }
}
