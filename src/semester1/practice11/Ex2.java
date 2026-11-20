package semester1.practice11;

import java.util.ArrayList;

import semester1.ConsoleOutput;

public class Ex2 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    showCompilerUnderTheHood();
  }

  public static void showCompilerUnderTheHood() {
    int a = 42;
    Integer boxed = a;
    ArrayList<Integer> list = new ArrayList<>();
    list.add(100);
    int unboxed = list.get(0);
    System.out.printf("Неявно: %d, %d%n", boxed, unboxed);

    Integer explicitBoxed = Integer.valueOf(a);
    ArrayList<Integer> explicitList = new ArrayList<>();
    explicitList.add(Integer.valueOf(100));
    int explicitUnboxed = explicitList.get(0).intValue();
    System.out.printf("Явно: %d, %d%n", explicitBoxed, explicitUnboxed);

    Double decimal = Double.valueOf(3.14);
    Boolean flag = Boolean.valueOf(true);
    System.out.printf("Double: %s, Boolean: %s%n", decimal.doubleValue(), flag.booleanValue());
  }
}
