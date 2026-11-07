package semester1.practice06;

public class Ex15 {
  static class Stopwatch {
    int seconds;

    public void tick() {
      seconds++;
    }

    public void addSeconds(int s) {
      if (s > 0) seconds += s;
    }

    public void displayTime() {
      System.out.printf("%02d:%02d%n", seconds / 60, seconds % 60);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Stopwatch s = new Stopwatch();
    s.addSeconds(124);
    s.tick();
    s.displayTime();
  }
}
