package semester1.practice06;

public class Ex37 {
  static class ArraySearcher {
    private int[] data = new int[0];

    public void setData(int[] data) {
      this.data = data.clone();
    }

    public boolean contains(int target) {
      return findIndex(target) >= 0;
    }

    public int findIndex(int target) {
      for (int i = 0; i < data.length; i++) if (data[i] == target) return i;
      return -1;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ArraySearcher s = new ArraySearcher();
    s.setData(new int[] {4, 8, 2, 8});
    for (int target : new int[] {8, 9})
      System.out.println(target + ": " + s.contains(target) + ", індекс " + s.findIndex(target));
  }
}
