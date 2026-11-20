package semester1.practice11;

import semester1.ConsoleOutput;

public class Ex8 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    convertNumberSystems(42);
    System.out.println("101010 (2) = " + Integer.parseInt("101010", 2));
    System.out.println("FF (16) = " + Integer.parseInt("FF", 16));
  }

  public static void convertNumberSystems(int number) {
    System.out.println("Двійкова: " + Integer.toBinaryString(number));
    System.out.println("Вісімкова: " + Integer.toOctalString(number));
    System.out.println("Шістнадцяткова: " + Integer.toHexString(number));
  }
}
