package semester1.practice08;

public class Ex25 {
  static class DotaHero {
    private String name, primaryAttribute;
    private int baseHp;

    public DotaHero(String name, String primaryAttribute, int baseHp) {
      this.name = name;
      this.primaryAttribute = primaryAttribute;
      this.baseHp = baseHp;
    }

    public int getMaxHp() {
      return baseHp;
    }

    public String toString() {
      return name + " | " + primaryAttribute + " | HP=" + getMaxHp();
    }
  }

  static class StrengthHero extends DotaHero {
    private int strength;

    public StrengthHero(String name, int baseHp, int strength) {
      super(name, "Strength", baseHp);
      this.strength = strength;
    }

    @Override
    public int getMaxHp() {
      return super.getMaxHp() + strength * 22;
    }

    @Override
    public String toString() {
      return super.toString() + " | strength=" + strength;
    }
  }

  static class AlchemistHero extends StrengthHero {
    private int greevilsGreedBonusGold;

    public AlchemistHero(String name, int baseHp, int strength, int bonus) {
      super(name, baseHp, strength);
      greevilsGreedBonusGold = bonus;
    }

    public void chemicalRage() {
      System.out.println("Chemical Rage активовано");
    }

    @Override
    public String toString() {
      return super.toString() + " | bonus gold=" + greevilsGreedBonusGold;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    AlchemistHero a = new AlchemistHero("Alchemist", 200, 23, 18);
    System.out.println(a);
    a.chemicalRage();
  }
}
