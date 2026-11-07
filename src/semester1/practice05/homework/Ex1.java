package semester1.practice05.homework;

import java.util.Arrays;
import java.util.Scanner;

public final class Ex1 {
  private Ex1() {}

  private static void sales(Scanner s) {
    String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
    double[] v = new double[7];
    for (int i = 0; i < 7; i++) {
      System.out.print(days[i] + " виторг: ");
      v[i] = Math.max(0, s.nextDouble());
    }
    double total = Arrays.stream(v).sum(), avg = total / v.length;
    int min = 0, max = 0;
    for (int i = 1; i < v.length; i++) {
      if (v[i] < v[min]) min = i;
      if (v[i] > v[max]) max = i;
    }
    System.out.printf(
        "Разом %.2f, середнє %.2f%nМаксимум: %s %.2f%nМінімум: %s %.2f%n",
        total, avg, days[max], v[max], days[min], v[min]);
    for (int i = 0; i < v.length; i++)
      if (v[i] > avg) System.out.println("Вище середнього: " + days[i]);
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N5, завдання 1 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      sales(s);
    }
  }
}
