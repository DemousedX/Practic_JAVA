package semester1.practice08.homework;

import java.util.Arrays;

public final class Ex5 {
  private Ex5() {}

  private static class DungeonEntity {
    private final String name;
    protected int level;
    protected int hp, maxHp, baseAttack, defense;

    DungeonEntity(String name, int level, int maxHp, int attack, int defense) {
      this.name = name;
      this.level = Math.max(1, level);
      this.maxHp = Math.max(1, maxHp);
      hp = this.maxHp;
      baseAttack = Math.max(0, attack);
      this.defense = Math.max(0, defense);
    }

    int takeDamage(int raw) {
      int actual = Math.max(5, raw - defense);
      hp = Math.max(0, hp - actual);
      return actual;
    }

    int performAttack() {
      return baseAttack;
    }

    boolean isAlive() {
      return hp > 0;
    }

    protected String health() {
      int filled = (int) Math.round(10.0 * hp / maxHp);
      return "[" + "#".repeat(filled) + "-".repeat(10 - filled) + "]";
    }

    @Override
    public String toString() {
      return String.format(
          "DungeonEntity{name='%s', lvl=%d, HP=%s %d/%d, ATK=%d, DEF=%d}",
          name, level, health(), hp, maxHp, baseAttack, defense);
    }
  }

  private static class Hunter extends DungeonEntity {
    private final char rank;
    protected int mana, maxMana;

    Hunter(String name, int level, int maxHp, int attack, int defense, char rank, int maxMana) {
      super(name, level, maxHp, attack, defense);
      this.rank = rank;
      this.maxMana = Math.max(0, maxMana);
      mana = this.maxMana;
    }

    int useManaSkill(String name, int cost, double multiplier) {
      if (cost > 0 && mana >= cost) {
        mana -= cost;
        System.out.println(name + " activated");
        return (int) (performAttack() * multiplier);
      }
      System.out.println("Недостатньо мани");
      return performAttack();
    }

    @Override
    public String toString() {
      return "Hunter{"
          + super.toString()
          + String.format(" | Ранг: [%s] | MP: %d/%d", rank, mana, maxMana)
          + "}";
    }
  }

  private static final class DungeonBoss extends DungeonEntity {
    private final String title;
    private boolean enraged;

    DungeonBoss(String name, int level, int hp, int attack, int defense, String title) {
      super(name, level, hp, attack, defense);
      this.title = title;
    }

    @Override
    int takeDamage(int raw) {
      int dealt = super.takeDamage(raw);
      if (hp > 0 && hp <= maxHp * .4 && !enraged) {
        enraged = true;
        System.out.println("Бос впадає у лють!");
      }
      return dealt;
    }

    @Override
    int performAttack() {
      return enraged ? (int) (super.performAttack() * 1.5) : super.performAttack();
    }

    @Override
    public String toString() {
      return "DungeonBoss{" + super.toString() + ", титул=" + title + ", rage=" + enraged + "}";
    }
  }

  private static final class ShadowMonarch extends Hunter {
    private final String[] shadows = new String[5];
    private final int[] bonuses = new int[5];
    private int count;

    ShadowMonarch(String name, int level, int hp, int mana, int attack, int defense) {
      super(name, level, hp, attack, defense, 'S', mana);
    }

    boolean arise(String name, int bonus) {
      if (mana < 30 || count == shadows.length || bonus < 0) return false;
      mana -= 30;
      shadows[count] = name;
      bonuses[count++] = bonus;
      return true;
    }

    int getTotalShadowBonus() {
      return Arrays.stream(bonuses, 0, count).sum();
    }

    @Override
    int performAttack() {
      return super.performAttack() + getTotalShadowBonus();
    }

    void levelUp() {
      levelUpStats();
    }

    private void levelUpStats() {
      level++;
      maxHp += 150;
      hp = maxHp;
      maxMana += 50;
      mana = maxMana;
      baseAttack += 25;
    }

    @Override
    public String toString() {
      return "ShadowMonarch{"
          + super.toString()
          + "} Тіні="
          + Arrays.toString(Arrays.copyOf(shadows, count))
          + ", бонус="
          + getTotalShadowBonus();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ShadowMonarch hero = new ShadowMonarch("Сон Джін-Ву", 45, 1200, 300, 180, 45);
    DungeonBoss boss = new DungeonBoss("Беру", 80, 2500, 260, 60, "Король мурах");
    hero.arise("Ігріс", 90);
    System.out.println(hero);
    for (int round = 1; round <= 4 && boss.isAlive(); round++) {
      System.out.println("Раунд " + round);
      int damage = boss.takeDamage(hero.performAttack());
      System.out.println("Бос втратив " + damage + " HP; атака боса " + boss.performAttack());
    }
    hero.arise("Танк", 70);
    hero.levelUp();
    System.out.println(hero);
  }
}
