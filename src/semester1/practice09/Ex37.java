package semester1.practice09;

import java.util.Arrays;

public final class Ex37 {
  private Ex37() {}

  abstract static class AbstractHeroUnit {
    private final String name;
    protected int hp;

    AbstractHeroUnit(String n, int hp) {
      name = n;
      this.hp = Math.max(0, hp);
    }

    public abstract int getCombatPower();

    public abstract String getRole();

    public String name() {
      return name;
    }
  }

  static final class TankWarrior extends AbstractHeroUnit {
    private final int armor;

    TankWarrior(String n, int hp, int armor) {
      super(n, hp);
      this.armor = armor;
    }

    public int getCombatPower() {
      return hp / 2 + armor * 2;
    }

    public String getRole() {
      return "Tank";
    }
  }

  static final class ArcaneMage extends AbstractHeroUnit {
    private final int intellect, spell;

    ArcaneMage(String n, int hp, int i, int s) {
      super(n, hp);
      intellect = i;
      spell = s;
    }

    public int getCombatPower() {
      return intellect * 2 + spell;
    }

    public String getRole() {
      return "ArcaneMage";
    }
  }

  static final class RaidParty {
    private final String guildName;
    private final AbstractHeroUnit[] members;
    private int memberCount;

    RaidParty(String g, int cap) {
      guildName = g;
      members = new AbstractHeroUnit[cap];
    }

    public void add(AbstractHeroUnit h) {
      if (h != null && memberCount < members.length) members[memberCount++] = h;
    }

    public int getCombatPower() {
      int p = 0;
      for (int i = 0; i < memberCount; i++) p += members[i].getCombatPower();
      return p;
    }

    public boolean ready(int difficulty) {
      boolean tank = false;
      for (int i = 0; i < memberCount; i++) if (members[i].getRole().equals("Tank")) tank = true;
      return tank && getCombatPower() > difficulty;
    }

    public String toString() {
      return guildName
          + " "
          + Arrays.toString(Arrays.copyOf(members, memberCount))
          + ", getCombatPower="
          + getCombatPower();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    var party = new RaidParty("North", 5);
    party.add(new TankWarrior("Aegis", 800, 70));
    party.add(new ArcaneMage("Luna", 300, 150, 220));
    System.out.println(party + ", ready=" + party.ready(800));
  }
}
