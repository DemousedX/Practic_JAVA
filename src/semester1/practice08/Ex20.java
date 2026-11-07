package semester1.practice08;

public class Ex20 {
  static class Weapon {
    private String title;
    private int baseDamage;

    public Weapon(String title, int baseDamage) {
      this.title = title;
      this.baseDamage = baseDamage;
    }

    public int calculateDamage() {
      return baseDamage;
    }

    public String toString() {
      return title + ", фізична шкода: " + baseDamage;
    }
  }

  static class EnchantedSword extends Weapon {
    private String element;
    private int magicPower, enchantmentLevel;

    public EnchantedSword(
        String title, int baseDamage, String element, int magicPower, int enchantmentLevel) {
      super(title, baseDamage);
      this.element = element;
      this.magicPower = magicPower;
      this.enchantmentLevel = enchantmentLevel;
    }

    @Override
    public int calculateDamage() {
      return super.calculateDamage() + magicPower * enchantmentLevel;
    }

    @Override
    public String toString() {
      return super.toString()
          + ", стихія: "
          + element
          + ", магічна шкода: "
          + magicPower * enchantmentLevel
          + ", загалом: "
          + calculateDamage();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new Weapon("Меч", 35));
    System.out.println(new EnchantedSword("Вогняний меч", 35, "Вогонь", 10, 3));
  }
}
