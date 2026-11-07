package semester1.practice08;

public final class Ex39 {
  private Ex39() {}

  static class CharacterUnit {
    protected String name;
    protected int hp, maxHp, armor;

    CharacterUnit(String name, int hp, int armor) {
      this.name = name;
      maxHp = Math.max(1, hp);
      this.hp = maxHp;
      this.armor = Math.max(0, armor);
    }

    public void takeDamage(int rawDamage) {
      hp = Math.max(0, hp - Math.max(1, rawDamage - armor));
    }

    @Override
    public String toString() {
      int bars = (int) Math.round(10.0 * hp / maxHp);
      return name + " [" + "#".repeat(bars) + "-".repeat(10 - bars) + "] " + hp + "/" + maxHp;
    }
  }

  static class ShieldedPaladin extends CharacterUnit {
    private int shieldPoints;

    ShieldedPaladin(String name, int hp, int armor, int shield) {
      super(name, hp, armor);
      shieldPoints = Math.max(0, shield);
    }

    @Override
    public void takeDamage(int rawDamage) {
      int absorbed = Math.min(shieldPoints, Math.max(0, rawDamage));
      shieldPoints -= absorbed;
      int remaining = rawDamage - absorbed;
      if (remaining > 0 && shieldPoints == 0) super.takeDamage(remaining);
    }

    @Override
    public String toString() {
      return super.toString() + " shield=" + shieldPoints;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 39 ---%n");

    ShieldedPaladin paladin = new ShieldedPaladin("Paladin", 1200, 40, 300);
    paladin.takeDamage(220);
    paladin.takeDamage(250);
    System.out.println(paladin);
  }
}
