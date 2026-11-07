package semester1.practice06;

public class Ex23 {
  static class TextFormatter {
    public String formatTitle(String text) {
      return "*** " + text.toUpperCase() + " ***";
    }

    public int countVowels(String text) {
      int n = 0;
      for (char c : text.toLowerCase().toCharArray()) if ("аоуеиіяюєїaeiou".indexOf(c) >= 0) n++;
      return n;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    TextFormatter f = new TextFormatter();
    System.out.println(f.formatTitle("Програмування"));
    System.out.println(f.countVowels("Програмування Java"));
  }
}
