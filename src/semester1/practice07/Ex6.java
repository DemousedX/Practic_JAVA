package semester1.practice07;

public class Ex6 {
  static class Time {
    private int hours, minutes, seconds;

    public Time(int hours, int minutes, int seconds) {
      this.hours = hours >= 0 && hours < 24 ? hours : 0;
      this.minutes = minutes >= 0 && minutes < 60 ? minutes : 0;
      this.seconds = seconds >= 0 && seconds < 60 ? seconds : 0;
    }

    public void tick() {
      if (++seconds == 60) {
        seconds = 0;
        if (++minutes == 60) {
          minutes = 0;
          hours = (hours + 1) % 24;
        }
      }
    }

    public String toUniversalString() {
      return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String toStandardString() {
      return String.format(
          "%d:%02d:%02d %s",
          hours % 12 == 0 ? 12 : hours % 12, minutes, seconds, hours < 12 ? "AM" : "PM");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Time t = new Time(23, 59, 59);
    System.out.println(t.toUniversalString());
    System.out.println(t.toStandardString());
    t.tick();
    System.out.println(t.toUniversalString());
    System.out.println(t.toStandardString());
    System.out.println(new Time(-2, 90, 80).toUniversalString());
  }
}
