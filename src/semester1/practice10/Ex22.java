package semester1.practice10;

public class Ex22 {

  abstract static class AbstractMilitaryUnit {
    private final String unitName;
    protected int hp;

    AbstractMilitaryUnit(String name, int hp) {
      unitName = name;
      this.hp = hp;
    }

    public abstract int getMoveSpeed();

    public String getUnitName() {
      return unitName;
    }
  }

  interface RangedAttacker {
    int getAttackRange();

    int fireShot();
  }

  interface FieldHealer {
    int healAlly();
  }

  static class HeavySniper extends AbstractMilitaryUnit implements RangedAttacker {
    HeavySniper() {
      super("Снайпер", 100);
    }

    @Override
    public int getMoveSpeed() {
      return 3;
    }

    @Override
    public int getAttackRange() {
      return 1000;
    }

    @Override
    public int fireShot() {
      return 80;
    }
  }

  static class CombatMedic extends AbstractMilitaryUnit implements FieldHealer {
    CombatMedic() {
      super("Медик", 120);
    }

    @Override
    public int getMoveSpeed() {
      return 5;
    }

    @Override
    public int healAlly() {
      return 40;
    }
  }

  static class PaladinCaptain extends AbstractMilitaryUnit implements RangedAttacker, FieldHealer {
    PaladinCaptain() {
      super("Паладин", 200);
    }

    @Override
    public int getMoveSpeed() {
      return 4;
    }

    @Override
    public int getAttackRange() {
      return 30;
    }

    @Override
    public int fireShot() {
      return 50;
    }

    @Override
    public int healAlly() {
      return 30;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    for (AbstractMilitaryUnit u :
        new AbstractMilitaryUnit[] {new HeavySniper(), new CombatMedic(), new PaladinCaptain()}) {
      System.out.println(u.getUnitName() + ", швидкість: " + u.getMoveSpeed());
      if (u instanceof RangedAttacker r)
        System.out.println("Дальність: " + r.getAttackRange() + ", шкода: " + r.fireShot());
      if (u instanceof FieldHealer h) System.out.println("Лікування: " + h.healAlly());
    }
  }
}
