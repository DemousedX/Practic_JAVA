package semester1.practice08;

public class Ex16 {
  static class Gamer {
    private String nickname;
    private int hoursPlayed;

    public Gamer(String nickname, int hoursPlayed) {
      this.nickname = nickname;
      this.hoursPlayed = Math.max(0, hoursPlayed);
    }

    public String toString() {
      return nickname + ", годин: " + hoursPlayed;
    }
  }

  static class ProEsportsPlayer extends Gamer {
    private String teamName;
    private double prizeMoneyUSD;
    private int tournamentsWon;

    public ProEsportsPlayer(
        String nickname,
        int hoursPlayed,
        String teamName,
        double prizeMoneyUSD,
        int tournamentsWon) {
      super(nickname, hoursPlayed);
      this.teamName = teamName;
      this.prizeMoneyUSD = Math.max(0, prizeMoneyUSD);
      this.tournamentsWon = Math.max(0, tournamentsWon);
    }

    public double getAveragePrizePerWin() {
      return tournamentsWon == 0 ? 0 : prizeMoneyUSD / tournamentsWon;
    }

    public String toString() {
      return super.toString()
          + ", команда: "
          + teamName
          + ", призові: "
          + prizeMoneyUSD
          + ", перемоги: "
          + tournamentsWon
          + ", середні призові: "
          + getAveragePrizePerWin();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new ProEsportsPlayer("Player", 1000, "Team", 30000, 3));
    System.out.println(new ProEsportsPlayer("NewPlayer", 100, "Team", 0, 0));
  }
}
