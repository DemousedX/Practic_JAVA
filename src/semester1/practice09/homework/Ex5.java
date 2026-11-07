package semester1.practice09.homework;

import java.util.Arrays;

public final class Ex5 {
  private static final class BioMonitor {
    private int hp = 1000, humanity = 100;

    void reduce(int n) {
      humanity = Math.max(0, humanity - n);
    }

    void restore(int n) {
      humanity = Math.min(100, humanity + n);
    }

    boolean unstable() {
      return humanity < 20;
    }

    void damage(int n) {
      hp = Math.max(0, hp - n);
    }

    public String toString() {
      return "HP=" + hp + ", humanity=" + humanity + (unstable() ? " (cyberpsychosis)" : "");
    }
  }

  private abstract static class Implant {
    private final String name, slot;
    private final int cost;

    Implant(String n, String s, int c) {
      name = n;
      slot = s;
      cost = c;
    }

    String slot() {
      return slot;
    }

    String name() {
      return name;
    }

    int cost() {
      return cost;
    }

    abstract int attack();

    abstract int armor();

    abstract String activate();

    public String toString() {
      return slot + ": " + name + " +" + attack() + " ATK +" + armor() + " DEF";
    }
  }

  private static final class Sandevistan extends Implant {
    Sandevistan() {
      super("Militech Apogee", "Neuro-OS", 35);
    }

    int attack() {
      return 90;
    }

    int armor() {
      return 20;
    }

    String activate() {
      return "Time slowed";
    }
  }

  private static final class Blades extends Implant {
    Blades() {
      super("Mantis Blades", "Arms", 25);
    }

    int attack() {
      return 110;
    }

    int armor() {
      return 5;
    }

    String activate() {
      return "Blades pierce armor";
    }
  }

  private static final class Armor extends Implant {
    Armor() {
      super("Titanium Armor", "Skin", 25);
    }

    int attack() {
      return 10;
    }

    int armor() {
      return 65;
    }

    String activate() {
      return "Nano plates absorb impact";
    }
  }

  private static final class Mercenary {
    private final String name;
    private final int base;
    private final BioMonitor bio = new BioMonitor();
    private final Implant[] implants = new Implant[4];
    private int count;

    Mercenary(String n, int b) {
      name = n;
      base = b;
    }

    boolean install(Implant x) {
      for (int i = 0; i < count; i++)
        if (implants[i].slot().equals(x.slot())) {
          System.out.println("Occupied slot: " + x.slot());
          return false;
        }
      implants[count++] = x;
      bio.reduce(x.cost());
      return true;
    }

    void fight() {
      for (int round = 1; round <= 4 && bio.hp > 0; round++) {
        int damage = base;
        for (int i = 0; i < count; i++) {
          damage += implants[i].attack();
          System.out.println(implants[i].activate());
        }
        if (bio.unstable()) {
          damage += damage / 2;
          bio.damage(100);
        }
        System.out.println("Round " + round + ": " + name + " attacks for " + damage + "; " + bio);
      }
    }

    void immunoblocker() {
      bio.restore(30);
      System.out.println("Immunoblocker: " + bio);
    }

    public String toString() {
      return name + ", implants=" + Arrays.toString(Arrays.copyOf(implants, count)) + ", " + bio;
    }
  }

  private void runTask() {
    Mercenary m = new Mercenary("David", 120);
    m.install(new Sandevistan());
    m.install(new Blades());
    m.install(new Sandevistan());
    m.install(new Armor());
    System.out.println(m);
    m.fight();
    m.immunoblocker();
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new Ex5().runTask();
  }
}
