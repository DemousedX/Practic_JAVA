package semester1.practice07;

public class Ex30 {
  static class StringUtils {
    private StringUtils() {}

    public static boolean isPalindrome(String s) {
      String value = s.replaceAll("\\s+", "").toLowerCase();
      return value.equals(reverse(value));
    }

    public static String reverse(String s) {
      return new StringBuilder(s).reverse().toString();
    }

    public static int countVowels(String s) {
      int n = 0;
      for (char c : s.toLowerCase().toCharArray()) if ("аоуеиіяюєїaeiou".indexOf(c) >= 0) n++;
      return n;
    }

    public static String maskCardNumber(String cardNumber) {
      String digits = cardNumber.replaceAll("\\D", "");
      if (digits.length() <= 4) return digits;
      String value = "*".repeat(digits.length() - 4) + digits.substring(digits.length() - 4);
      return value.replaceAll("(.{4})(?!$)", "$1 ");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(StringUtils.isPalindrome("А роза упала на лапу Азора"));
    System.out.println(StringUtils.reverse("Java"));
    System.out.println(StringUtils.countVowels("Програмування"));
    System.out.println(StringUtils.maskCardNumber("1234567812341234"));
  }
}
