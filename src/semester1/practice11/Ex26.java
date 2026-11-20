package semester1.practice11;

import java.util.ArrayList;

import semester1.ConsoleOutput;

public class Ex26 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    demonstrateVarDiamondDanger();
  }

  public static void demonstrateVarDiamondDanger() {
    var unsafeList = new ArrayList<>();
    unsafeList.add(42);
    unsafeList.add("Java");
    unsafeList.add(true);
    System.out.println("ArrayList<Object>: " + unsafeList);
    try {
      for (Object item : unsafeList) {
        System.out.println((Integer) item);
      }
    } catch (ClassCastException e) {
      System.out.println("ClassCastException: рядок не можна привести до Integer");
    }
    var safeList = new ArrayList<Integer>();
    safeList.add(42);
    System.out.println("ArrayList<Integer>: " + safeList.get(0));
  }
}
