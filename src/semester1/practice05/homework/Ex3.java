package semester1.practice05.homework;

import java.util.Arrays;
import java.util.Scanner;

public final class Ex3 {
  private Ex3() {}

  private static void cinema(Scanner s) {
    char[][] h = new char[5][6];
    for (char[] r : h) Arrays.fill(r, 'O');
    int option;
    do {
      System.out.println("1 - зал, 2 - бронювання, 3 - каса, 0 - вихід");
      option = s.nextInt();
      switch (option) {
        case 1 -> {
          System.out.println("    1 2 3 4 5 6");
          for (int r = 0; r < 5; r++)
            System.out.println("Р" + (r + 1) + ": " + Arrays.toString(h[r]));
        }
        case 2 -> {
          System.out.print("Ряд (1-5) і місце (1-6): ");
          int r = s.nextInt() - 1, c = s.nextInt() - 1;
          if (r < 0 || r >= 5 || c < 0 || c >= 6) System.out.println("Координати поза залом");
          else if (h[r][c] == 'X') System.out.println("Місце вже зайняте");
          else {
            h[r][c] = 'X';
            System.out.println("Місце заброньовано");
          }
        }
        case 3 -> {
          int booked = 0;
          for (char[] r : h) for (char c : r) if (c == 'X') booked++;
          System.out.printf("Зайнято %d/30, каса %.2f грн%n", booked, booked * 180.0);
        }
        case 0 -> System.out.println("Зміну закрито");
        default -> System.out.println("Немає такого пункту");
      }
    } while (option != 0);
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N5, завдання 3 ---%n");
    try (Scanner s = new Scanner(System.in)) {
      cinema(s);
    }
  }
}
