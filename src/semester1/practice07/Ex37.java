package semester1.practice07;

public class Ex37 {
  static class Hero {
    private String name;
    private int health, attackPower, defense;

    public Hero(String name, int health, int attackPower, int defense) {
      this.name = name;
      this.health = health;
      this.attackPower = attackPower;
      this.defense = defense;
    }

    public void attack(Hero target) {
      if (target == null || !isAlive() || !target.isAlive()) return;
      int damage = Math.max(1, attackPower - target.defense);
      target.health = Math.max(0, target.health - damage);
      System.out.println(
          name + " атакує " + target.name + ": -" + damage + " HP, залишилось " + target.health);
    }

    public boolean isAlive() {
      return health > 0;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Hero a = new Hero("Лицар", 100, 25, 10), b = new Hero("Орк", 120, 22, 5);
    while (a.isAlive() && b.isAlive()) {
      a.attack(b);
      if (b.isAlive()) b.attack(a);
    }
    System.out.println("Переможець: " + (a.isAlive() ? a.name : b.name));
  }
}
