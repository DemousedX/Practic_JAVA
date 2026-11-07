package semester1.practice09;

public class Ex23 {
  static class TrainCarriage {
    private final int carriageNumber;
    private final String type;
    private final int totalSeats;
    private int occupiedSeats;

    public TrainCarriage(int carriageNumber, String type, int totalSeats) {
      this.carriageNumber = carriageNumber;
      this.type = type;
      this.totalSeats = Math.max(0, totalSeats);
    }

    public int getFreeSeats() {
      return totalSeats - occupiedSeats;
    }

    public boolean book(int count) {
      if (count <= 0 || count > getFreeSeats()) return false;
      occupiedSeats += count;
      return true;
    }

    public String toString() {
      return carriageNumber + " | " + type + " | free=" + getFreeSeats();
    }
  }

  static class PassengerTrain {
    private final String route;
    private final TrainCarriage[] carriages;
    private int carriageCount;

    public PassengerTrain(String route, int capacity) {
      this.route = route;
      carriages = new TrainCarriage[capacity];
    }

    public void attachCarriage(TrainCarriage c) {
      if (c == null || carriageCount == carriages.length) return;
      for (int i = 0; i < carriageCount; i++)
        if (carriages[i].carriageNumber == c.carriageNumber) return;
      carriages[carriageCount++] = c;
    }

    public int getTotalFreeSeats() {
      int count = 0;
      for (int i = 0; i < carriageCount; i++) count += carriages[i].getFreeSeats();
      return count;
    }

    public boolean bookTicketsInCarriage(int carriageNumber, int seatsToBook) {
      for (int i = 0; i < carriageCount; i++)
        if (carriages[i].carriageNumber == carriageNumber) return carriages[i].book(seatsToBook);
      return false;
    }

    public String toString() {
      return route
          + " | "
          + java.util.Arrays.toString(java.util.Arrays.copyOf(carriages, carriageCount))
          + " | free="
          + getTotalFreeSeats();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    PassengerTrain t = new PassengerTrain("Київ-Одеса", 4);
    t.attachCarriage(new TrainCarriage(1, "Купе", 36));
    t.attachCarriage(new TrainCarriage(2, "Інтерсіті", 50));
    System.out.println(t.bookTicketsInCarriage(1, 4));
    System.out.println(t.bookTicketsInCarriage(1, 100));
    System.out.println(t);
  }
}
