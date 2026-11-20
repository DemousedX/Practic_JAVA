package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex6 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<Integer> temperatures = new ArrayList<>(Arrays.asList(18, 22, null, 15, null, 20));
    try {
      int temperature = temperatures.get(2);
      System.out.println(temperature);
    } catch (NullPointerException e) {
      System.out.println("NullPointerException: null не можна розпакувати в int");
    }
    System.out.println("Сума без null: " + sumIgnoringNulls(temperatures));
  }

  public static int sumIgnoringNulls(List<Integer> list) {
    int sum = 0;
    for (Integer element : list) {
      if (element != null) sum += element;
    }
    return sum;
  }
}
