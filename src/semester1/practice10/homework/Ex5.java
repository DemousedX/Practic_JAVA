package semester1.practice10.homework;

public class Ex5 {

  interface FlyingMonster {
    boolean isAirborne();

    void knockDownToGround();
  }

  interface RegeneratingMonster {
    int regenerateHealth();

    void applyMoonDustBomb();
  }

  interface SpectralPhantom {
    boolean isIncorporeal();

    void bindWithYrdenSign();
  }

  abstract static class AbstractMonster {
    private final String name, bestiaryCategory;
    protected int hp;
    protected final int maxHp;

    AbstractMonster(String name, String category, int hp) {
      if (hp <= 0) throw new IllegalArgumentException("HP має бути додатним");
      this.name = name;
      bestiaryCategory = category;
      this.hp = hp;
      maxHp = hp;
    }

    public abstract int calculateMonsterAttack();

    public abstract String getBattleCry();

    public final boolean isAlive() {
      return hp > 0;
    }

    public void receiveDamage(int dmg) {
      hp = Math.max(0, hp - Math.max(0, dmg));
    }

    public int getHp() {
      return hp;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      int filled = (int) Math.ceil(10.0 * hp / maxHp);
      return name
          + " ["
          + bestiaryCategory
          + " | "
          + "#".repeat(filled)
          + "-".repeat(10 - filled)
          + " | HP: "
          + hp
          + "/"
          + maxHp
          + "]";
    }
  }

  static class RoyalGriffin extends AbstractMonster implements FlyingMonster {
    private boolean airborne = true;

    RoyalGriffin() {
      super("Королівський грифон", "Гібриди", 400);
    }

    @Override
    public int calculateMonsterAttack() {
      return 60;
    }

    @Override
    public String getBattleCry() {
      return "Грифон пронизливо кричить";
    }

    @Override
    public boolean isAirborne() {
      return airborne;
    }

    @Override
    public void knockDownToGround() {
      airborne = false;
    }

    @Override
    public void receiveDamage(int dmg) {
      super.receiveDamage(airborne ? dmg / 2 : dmg);
    }
  }

  static class Noonwraith extends AbstractMonster implements SpectralPhantom {
    private boolean incorporeal = true;

    Noonwraith() {
      super("Полудниця", "Примари", 300);
    }

    @Override
    public int calculateMonsterAttack() {
      return 45;
    }

    @Override
    public String getBattleCry() {
      return "Примара здіймає холодний вітер";
    }

    @Override
    public boolean isIncorporeal() {
      return incorporeal;
    }

    @Override
    public void bindWithYrdenSign() {
      incorporeal = false;
    }

    @Override
    public void receiveDamage(int dmg) {
      super.receiveDamage(incorporeal ? (int) Math.round(dmg * 0.2) : dmg);
    }
  }

  static class HigherVampire extends AbstractMonster implements FlyingMonster, RegeneratingMonster {
    private boolean airborne = true, regenBlocked;

    HigherVampire() {
      super("Детлафф", "Вампіри", 650);
    }

    @Override
    public int calculateMonsterAttack() {
      return 90;
    }

    @Override
    public String getBattleCry() {
      return "Вампір розчиняється в тумані";
    }

    @Override
    public boolean isAirborne() {
      return airborne;
    }

    @Override
    public void knockDownToGround() {
      airborne = false;
    }

    @Override
    public void receiveDamage(int dmg) {
      super.receiveDamage(airborne ? dmg / 2 : dmg);
    }

    @Override
    public int regenerateHealth() {
      if (regenBlocked || !isAlive()) return 0;
      int restored = Math.min(120, maxHp - hp);
      hp += restored;
      return restored;
    }

    @Override
    public void applyMoonDustBomb() {
      regenBlocked = true;
    }
  }

  public static final class AncientLeshen extends AbstractMonster implements RegeneratingMonster {
    private boolean regenBlocked;

    AncientLeshen() {
      super("Прадавній лісовик", "Релікти", 800);
    }

    @Override
    public int calculateMonsterAttack() {
      return 75;
    }

    @Override
    public String getBattleCry() {
      return "Лісовик скликає зграю воронів";
    }

    @Override
    public int regenerateHealth() {
      if (regenBlocked || !isAlive()) return 0;
      int restored = Math.min(80, maxHp - hp);
      hp += restored;
      return restored;
    }

    @Override
    public void applyMoonDustBomb() {
      regenBlocked = true;
    }
  }

  static class WitcherHunter {
    private final String name;
    private final int silverSwordAttack;

    WitcherHunter(String name, int attack) {
      if (attack <= 0) throw new IllegalArgumentException("Шкода має бути додатною");
      this.name = name;
      silverSwordAttack = attack;
    }

    public void applyBestiaryTactics(AbstractMonster target) {
      if (target instanceof SpectralPhantom sp && sp.isIncorporeal()) {
        sp.bindWithYrdenSign();
        System.out.println("Ірден: примара матеріалізована");
      }
      if (target instanceof FlyingMonster fm && fm.isAirborne()) {
        fm.knockDownToGround();
        System.out.println("Аард: монстра збито на землю");
      }
      if (target instanceof RegeneratingMonster rm) {
        rm.applyMoonDustBomb();
        System.out.println("Місячний пил: регенерацію заблоковано");
      }
    }

    public final int executeSilverStrike(AbstractMonster target) {
      if (target == null || !target.isAlive()) return 0;
      applyBestiaryTactics(target);
      int before = target.getHp();
      target.receiveDamage(silverSwordAttack);
      int dealt = before - target.getHp();
      System.out.println(name + " завдав " + dealt + " шкоди");
      return dealt;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    AbstractMonster[] contracts = {
      new RoyalGriffin(), new Noonwraith(), new HigherVampire(), new AncientLeshen()
    };
    WitcherHunter hunter = new WitcherHunter("Ґеральт", 220);
    for (AbstractMonster monster : contracts) {
      System.out.println("Контракт: " + monster);
      System.out.println(monster.getBattleCry());
      int round = 0;
      while (monster.isAlive()) {
        System.out.println("Раунд " + (++round));
        hunter.executeSilverStrike(monster);
        if (monster instanceof RegeneratingMonster rm)
          System.out.println("Регенерація: " + rm.regenerateHealth());
        if (monster.isAlive())
          System.out.println("Контратака монстра: " + monster.calculateMonsterAttack());
        System.out.println(monster);
      }
      System.out.println("Контракт виконано");
    }
  }
}
