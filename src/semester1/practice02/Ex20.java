package semester1.practice02;

import java.util.Locale;

public final class Ex20 {
  private Ex20() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 20 ---%n");
    int score = 100;
    score += 50;
    System.out.println("Після додавання: " + score);
    score -= 20;
    System.out.println("Після віднімання: " + score);
    score *= 2;
    System.out.println("Після множення: " + score);
    score /= 4;
    System.out.println("Після ділення: " + score);
  }
}
