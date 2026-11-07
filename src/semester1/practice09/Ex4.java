package semester1.practice09;

public class Ex4 {
  static class ClosedInterval {
    private double start, end;

    public ClosedInterval(double start, double end) {
      resize(start, end);
    }

    public void resize(double newStart, double newEnd) {
      start = Math.min(newStart, newEnd);
      end = Math.max(newStart, newEnd);
    }

    public double getLength() {
      return end - start;
    }

    public double getMidpoint() {
      return start + (end - start) / 2;
    }

    public boolean overlaps(ClosedInterval other) {
      return other != null && start <= other.end && other.start <= end;
    }

    public String toString() {
      return "["
          + start
          + "; "
          + end
          + "] (центр: "
          + getMidpoint()
          + ", довжина: "
          + getLength()
          + ")";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ClosedInterval a = new ClosedInterval(8, 2), b = new ClosedInterval(4, 10);
    System.out.println(a);
    System.out.println(a.overlaps(b));
    a.resize(20, 12);
    System.out.println(a);
    System.out.println(a.overlaps(b));
  }
}
