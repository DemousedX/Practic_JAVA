package semester1.practice09;

public class Ex5 {
  static final class RgbColor {
    private final int red, green, blue;

    private static int clamp(int val) {
      return Math.max(0, Math.min(255, val));
    }

    public RgbColor(int red, int green, int blue) {
      this.red = clamp(red);
      this.green = clamp(green);
      this.blue = clamp(blue);
    }

    public String toHex() {
      return String.format("#%02X%02X%02X", red, green, blue);
    }

    public RgbColor invert() {
      return new RgbColor(255 - red, 255 - green, 255 - blue);
    }

    public RgbColor mixWith(RgbColor other) {
      return new RgbColor(
          (red + other.red) / 2, (green + other.green) / 2, (blue + other.blue) / 2);
    }

    public String toString() {
      return "RGB(" + red + ", " + green + ", " + blue + ") " + toHex();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    RgbColor c = new RgbColor(-10, 150, 300);
    System.out.println(c);
    System.out.println(c.invert());
    System.out.println(c.mixWith(new RgbColor(255, 50, 20)));
  }
}
