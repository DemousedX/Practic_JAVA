package semester1.practice07;

public class Ex16 {
  static class FlightTicket {
    String ticketNumber, passengerName, flightNumber, departureCity, arrivalCity, seatNumber;
    boolean hasBaggage;

    public FlightTicket(
        String ticketNumber,
        String passengerName,
        String flightNumber,
        String departureCity,
        String arrivalCity,
        String seatNumber,
        boolean hasBaggage) {
      this.ticketNumber = ticketNumber;
      this.passengerName = passengerName;
      this.flightNumber = flightNumber;
      this.departureCity = departureCity;
      this.arrivalCity = arrivalCity;
      this.seatNumber = seatNumber;
      this.hasBaggage = hasBaggage;
    }

    public FlightTicket(
        String ticketNumber,
        String passengerName,
        String flightNumber,
        String departureCity,
        String arrivalCity) {
      this(
          ticketNumber,
          passengerName,
          flightNumber,
          departureCity,
          arrivalCity,
          "UNASSIGNED",
          false);
    }

    public void assignSeat(String seat) {
      this.seatNumber = seat;
    }

    public void printBoardingPass() {
      System.out.printf(
          "%s | %s | %s | %s - %s | %s | багаж %s%n",
          ticketNumber,
          passengerName,
          flightNumber,
          departureCity,
          arrivalCity,
          seatNumber,
          hasBaggage);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    FlightTicket t = new FlightTicket("T01", "Олександр", "FL123", "Варшава", "Лондон");
    t.printBoardingPass();
    t.assignSeat("12A");
    t.printBoardingPass();
  }
}
