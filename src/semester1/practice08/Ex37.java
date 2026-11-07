package semester1.practice08;

public final class Ex37 {
  private Ex37() {}

  static class CinemaHall {
    protected String hallName;
    protected boolean[][] seats;
    protected double baseTicketPrice;

    CinemaHall(String name, int rows, int columns, double price) {
      hallName = name;
      seats = new boolean[rows][columns];
      baseTicketPrice = price;
    }

    public boolean bookSeat(int row, int col) {
      if (row < 0 || row >= seats.length || col < 0 || col >= seats[row].length || seats[row][col])
        return false;
      seats[row][col] = true;
      return true;
    }

    public int getOccupiedCount() {
      int count = 0;
      for (boolean[] row : seats) for (boolean occupied : row) if (occupied) count++;
      return count;
    }

    public double calculateRevenue() {
      return getOccupiedCount() * baseTicketPrice;
    }

    @Override
    public String toString() {
      StringBuilder out = new StringBuilder(hallName).append('\n');
      for (boolean[] row : seats) {
        for (boolean occupied : row) out.append(occupied ? "[X]" : "[O]");
        out.append('\n');
      }
      return out + "Occupied=" + getOccupiedCount() + ", revenue=" + calculateRevenue();
    }
  }

  static class VipCinemaHall extends CinemaHall {
    private double complimentaryBarCost;

    VipCinemaHall(String name, int rows, int columns, double price, double barCost) {
      super(name, rows, columns, price);
      complimentaryBarCost = barCost;
    }

    @Override
    public double calculateRevenue() {
      int lastRow = seats.length - 1, vip = 0, regular = 0;
      for (int r = 0; r < seats.length; r++)
        for (boolean occupied : seats[r])
          if (occupied) {
            if (r == lastRow) vip++;
            else regular++;
          }
      return regular * baseTicketPrice + vip * (baseTicketPrice + complimentaryBarCost);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 37 ---%n");

    VipCinemaHall hall = new VipCinemaHall("Hall A", 4, 6, 180, 65);
    hall.bookSeat(0, 2);
    hall.bookSeat(3, 1);
    System.out.println(hall);
  }
}
