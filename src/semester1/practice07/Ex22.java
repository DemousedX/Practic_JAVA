package semester1.practice07;

public class Ex22 {
  static class DateService {
    int day, month, year;

    public DateService(int day, int month, int year) {
      this.day = day;
      this.month = month;
      this.year = year;
    }

    public void add(int days) {
      add(days, 0, 0);
    }

    public void add(int days, int months) {
      add(days, months, 0);
    }

    public void add(int days, int months, int years) {
      long total = ((long) (year + years) * 12 + month - 1 + months) * 30 + day - 1 + days;
      year = (int) Math.floorDiv(total, 360);
      month = (int) Math.floorMod(total, 360) / 30 + 1;
      day = (int) Math.floorMod(total, 30) + 1;
    }

    public void printDate() {
      System.out.printf("%02d.%02d.%04d%n", day, month, year);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    DateService d = new DateService(15, 3, 2024);
    d.printDate();
    d.add(20);
    d.printDate();
    d.add(0, 3);
    d.printDate();
    d.add(5, 1, 1);
    d.printDate();
  }
}
