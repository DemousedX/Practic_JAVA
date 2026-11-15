package semester1.practice10;

public class Ex24 {

  interface TextProcessor {
    String process(String text);
  }

  interface ReversibleProcessor extends TextProcessor {
    String reverseProcess(String text);
  }

  static class CaesarCipherProcessor implements ReversibleProcessor {
    private final int shift;

    CaesarCipherProcessor(int shift) {
      this.shift = Math.floorMod(shift, 26);
    }

    private String convert(String text, int k) {
      StringBuilder out = new StringBuilder();
      for (char c : text.toCharArray()) {
        if (c >= 'a' && c <= 'z') out.append((char) ('a' + Math.floorMod(c - 'a' + k, 26)));
        else if (c >= 'A' && c <= 'Z') out.append((char) ('A' + Math.floorMod(c - 'A' + k, 26)));
        else out.append(c);
      }
      return out.toString();
    }

    @Override
    public String process(String text) {
      return convert(text, shift);
    }

    @Override
    public String reverseProcess(String text) {
      return convert(text, -shift);
    }
  }

  static class WhitespaceTrimmerProcessor implements TextProcessor {
    @Override
    public String process(String text) {
      return text.strip().replaceAll("\\s+", " ");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    String text = "  Hello   Java  ";
    for (TextProcessor p :
        new TextProcessor[] {new WhitespaceTrimmerProcessor(), new CaesarCipherProcessor(3)}) {
      String next = p.process(text);
      System.out.println(next);
      if (p instanceof ReversibleProcessor r)
        System.out.println("Зворотне: " + r.reverseProcess(next));
      text = next;
    }
  }
}
