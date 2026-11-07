package semester1.practice06;

public class Ex13 {
  static class Player {
    String nickname;
    int health = 100;

    public void takeDamage(int damage) {
      if (damage <= 0) return;
      health = Math.max(0, health - damage);
      if (health == 0) System.out.println(nickname + " загинув!");
    }

    public void heal(int amount) {
      if (amount > 0) health = Math.min(100, health + amount);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Player p = new Player();
    p.nickname = "Player";
    p.takeDamage(40);
    System.out.println(p.health);
    p.heal(20);
    System.out.println(p.health);
    p.heal(100);
    System.out.println(p.health);
    p.takeDamage(150);
    System.out.println(p.health);
  }
}
