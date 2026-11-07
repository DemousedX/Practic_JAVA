package semester1.practice06;

public class Ex11 {
  static class Counter {
    int count;

    public void increment() {
      count++;
    }

    public void decrement() {
      count--;
    }

    public void reset() {
      count = 0;
    }

    public void printCount() {
      System.out.println(count);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Counter c = new Counter();
    c.increment();
    c.increment();
    c.increment();
    c.decrement();
    c.printCount();
    c.reset();
    c.printCount();
  }
}
