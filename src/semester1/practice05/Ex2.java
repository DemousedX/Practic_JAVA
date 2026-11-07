package semester1.practice05;

import java.util.Arrays;

public class Ex2 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
    System.out.println(days.length);
    System.out.println(days[0] + " | " + days[days.length - 1]);
    days[5] = "Вихідний (Сб)";
    days[6] = "Вихідний (Нд)";
    System.out.println(Arrays.toString(days));
  }
}
