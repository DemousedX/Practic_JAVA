package semester1.practice08;

public final class Ex7 {
  private Ex7() {}

  static class IntRange {
    private int min, max;

    IntRange(int min, int max) {
      setBounds(min, max);
    }

    public void setBounds(int first, int second) {
      min = Math.min(first, second);
      max = Math.max(first, second);
    }

    public boolean contains(int value) {
      return value >= min && value <= max;
    }

    public int getLength() {
      return max - min;
    }

    @Override
    public String toString() {
      return "[" + min + " .. " + max + "] (length=" + getLength() + ")";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 07 ---%n");

    IntRange range = new IntRange(12, -3);
    System.out.println(range);
    System.out.println("Contains 0: " + range.contains(0));
  }
}
