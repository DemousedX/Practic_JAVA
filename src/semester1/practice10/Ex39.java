package semester1.practice10;

public class Ex39 {

  abstract static class AbstractCombatUnit {
    private final String name;
    protected int hp;
    protected final int maxHp;

    AbstractCombatUnit(String name, int hp) {
      this.name = name;
      this.hp = hp;
      maxHp = hp;
    }

    public final boolean isAlive() {
      return hp > 0;
    }

    public abstract int calculateDamage();

    public String getName() {
      return name;
    }
  }

  interface CriticalStriker {
    double getCritMultiplier();
  }

  interface SelfRegenerating {
    int regenerateHp();
  }

  interface ShieldBearer {
    int absorbDamage(int incoming);
  }

  static class BerserkerAssasin extends AbstractCombatUnit implements CriticalStriker {
    BerserkerAssasin() {
      super("Берсерк", 200);
    }

    @Override
    public int calculateDamage() {
      return 60;
    }

    @Override
    public double getCritMultiplier() {
      return 2;
    }
  }

  static class TrollWarlord extends AbstractCombatUnit
      implements CriticalStriker, SelfRegenerating {
    TrollWarlord() {
      super("Троль", 300);
    }

    @Override
    public int calculateDamage() {
      return 50;
    }

    @Override
    public double getCritMultiplier() {
      return 1.5;
    }

    @Override
    public int regenerateHp() {
      int restored = Math.min(30, maxHp - hp);
      if (!isAlive()) return 0;
      hp += restored;
      return restored;
    }
  }

  static class RoyalPaladin extends AbstractCombatUnit implements ShieldBearer, SelfRegenerating {
    RoyalPaladin() {
      super("Паладин", 250);
    }

    @Override
    public int calculateDamage() {
      return 40;
    }

    @Override
    public int absorbDamage(int incoming) {
      return Math.max(0, incoming - 20);
    }

    @Override
    public int regenerateHp() {
      int restored = Math.min(20, maxHp - hp);
      if (!isAlive()) return 0;
      hp += restored;
      return restored;
    }
  }

  static void fightRound(AbstractCombatUnit[] units) {
    for (int i = 0; i < units.length; i++) {
      AbstractCombatUnit attacker = units[i], defender = units[(i + 1) % units.length];
      if (!attacker.isAlive() || !defender.isAlive()) continue;
      if (attacker instanceof SelfRegenerating reg)
        System.out.println(attacker.getName() + " відновив " + reg.regenerateHp());
      int damage = attacker.calculateDamage();
      if (attacker instanceof CriticalStriker crit)
        damage = (int) Math.round(damage * crit.getCritMultiplier());
      if (defender instanceof ShieldBearer shield) damage = shield.absorbDamage(damage);
      defender.hp = Math.max(0, defender.hp - damage);
      System.out.println(
          attacker.getName() + " -> " + defender.getName() + ": " + damage + ", HP=" + defender.hp);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    fightRound(
        new AbstractCombatUnit[] {new BerserkerAssasin(), new TrollWarlord(), new RoyalPaladin()});
  }
}
