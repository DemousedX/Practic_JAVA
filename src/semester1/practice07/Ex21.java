package semester1.practice07;

public class Ex21 {
  static class ArraySearcher {
    public int find(int[] arr, int target) {
      return find(arr, target, 0);
    }

    public int find(int[] arr, int target, int startIndex) {
      for (int i = Math.max(0, startIndex); i < arr.length; i++) if (arr[i] == target) return i;
      return -1;
    }

    public int find(String[] arr, String target) {
      return find(arr, target, false);
    }

    public int find(String[] arr, String target, boolean ignoreCase) {
      for (int i = 0; i < arr.length; i++)
        if (ignoreCase ? arr[i].equalsIgnoreCase(target) : arr[i].equals(target)) return i;
      return -1;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ArraySearcher s = new ArraySearcher();
    int[] a = {2, 4, 2, 8};
    String[] b = {"Java", "Math"};
    System.out.println(s.find(a, 2));
    System.out.println(s.find(a, 2, 1));
    System.out.println(s.find(b, "Math"));
    System.out.println(s.find(b, "java", true));
    System.out.println(s.find(a, 9));
  }
}
