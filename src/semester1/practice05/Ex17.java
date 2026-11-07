package semester1.practice05;

import java.util.Arrays;

public class Ex17 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    double[] salaries = {20000, 25000, 18000, 30000};
    for (int i = 0; i < salaries.length; i++) {
      salaries[i] *= 1.10;
    }
    System.out.println(Arrays.toString(salaries));
  }
}
