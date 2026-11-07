package semester1.practice09;

public class Ex14 {
  static class WeaponItem {
    private final String name;
    private final int bonusDamage;
    private int durability;

    public WeaponItem(String name, int bonusDamage, int durability) {
      this.name = name;
      this.bonusDamage = Math.max(0, bonusDamage);
      this.durability = Math.max(0, Math.min(100, durability));
    }

    public int useWeapon() {
      if (durability == 0) return 0;
      durability = Math.max(0, durability - 10);
      return bonusDamage;
    }

    public String toString() {
      return name + " | durability=" + durability;
    }
  }

  static class HeroCharacter {
    private final String nickname;
    private int baseStrength;
    private WeaponItem equippedWeapon;

    public HeroCharacter(String nickname, int baseStrength) {
      this.nickname = nickname;
      this.baseStrength = baseStrength;
    }

    public void equip(WeaponItem newWeapon) {
      equippedWeapon = newWeapon;
    }

    public void unequip() {
      equippedWeapon = null;
    }

    public int attack() {
      return baseStrength + (equippedWeapon == null ? 0 : equippedWeapon.useWeapon());
    }

    public String toString() {
      return nickname + " | " + equippedWeapon;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    HeroCharacter h = new HeroCharacter("Лицар", 20);
    h.equip(new WeaponItem("Меч", 30, 20));
    for (int i = 0; i < 3; i++) System.out.println(h.attack() + " | " + h);
    h.equip(new WeaponItem("Сокира", 40, 100));
    System.out.println(h.attack());
    h.unequip();
    System.out.println(h.attack());
  }
}
