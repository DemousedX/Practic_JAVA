package semester1.practice07;

public class Ex24 {
  static class ArrayFilter {
    public int[] filter(int[] arr, int threshold) {
      return java.util.Arrays.stream(arr).filter(x -> x > threshold).toArray();
    }

    public int[] filter(int[] arr, int min, int max) {
      return java.util.Arrays.stream(arr).filter(x -> x >= min && x <= max).toArray();
    }

    public int[] filter(int[] arr, boolean keepEvens) {
      return java.util.Arrays.stream(arr).filter(x -> (x % 2 == 0) == keepEvens).toArray();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ArrayFilter f = new ArrayFilter();
    int[] a = {12, 5, 8, 19, 24, 3, 16};
    System.out.println(java.util.Arrays.toString(f.filter(a, 10)));
    System.out.println(java.util.Arrays.toString(f.filter(a, 5, 16)));
    System.out.println(java.util.Arrays.toString(f.filter(a, true)));
    System.out.println(java.util.Arrays.toString(f.filter(a, false)));
  }
}
