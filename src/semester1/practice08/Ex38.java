package semester1.practice08;

import java.util.Arrays;
import semester1.practice08.Ex9.Developer;

public final class Ex38 {
  private Ex38() {}

  static class TeamLead extends Developer {
    private Developer[] teamMembers = new Developer[5];
    private int memberCount;

    TeamLead(String name, double salary, String language) {
      super(name, salary, language);
    }

    public void addTeamMember(Developer dev) {
      if (dev != null && memberCount < teamMembers.length) teamMembers[memberCount++] = dev;
    }

    public double getTotalTeamBudget() {
      double total = getSalary();
      for (int i = 0; i < memberCount; i++) total += teamMembers[i].getSalary();
      return total;
    }

    @Override
    public String toString() {
      return super.toString()
          + ", team="
          + Arrays.toString(Arrays.copyOf(teamMembers, memberCount))
          + ", budget="
          + getTotalTeamBudget();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 38 ---%n");

    TeamLead lead = new TeamLead("Ірина", 85000, "Java");
    lead.addTeamMember(new Developer("Павло", 65000, "Java"));
    lead.addTeamMember(new Developer("Оксана", 62000, "Kotlin"));
    System.out.println(lead);
  }
}
