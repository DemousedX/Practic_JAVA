package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex7 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    System.out.println(extractDigitsFromText("Server-04: CPU 85%, RAM 16GB"));
    double temperature = Double.parseDouble("36.6");
    Double price = Double.valueOf("99.95");
    for (double value : new double[] {temperature, price, Double.NaN, Double.POSITIVE_INFINITY}) {
      System.out.printf("%s: скінченне = %s%n", value, !Double.isNaN(value) && !Double.isInfinite(value));
    }
  }

  public static List<Integer> extractDigitsFromText(String text) {
    List<Integer> digits = new ArrayList<>();
    for (int offset = 0; offset < text.length();) {
      int character = text.codePointAt(offset);
      if (Character.isDigit(character)) digits.add(Character.getNumericValue(character));
      offset += Character.charCount(character);
    }
    return digits;
  }
}
