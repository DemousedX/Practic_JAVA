package semester1.practice09;

public final class Ex32 {
  private Ex32() {}

  abstract static class AbstractCompressor {
    private final String algorithmName;

    AbstractCompressor(String n) {
      algorithmName = n;
    }

    public abstract int estimateCompressedSize(int original);

    public double getCompressionRatio(int original) {
      return original <= 0 ? 0 : 100.0 * (original - estimateCompressedSize(original)) / original;
    }

    public String toString() {
      return algorithmName
          + ": compressed size="
          + estimateCompressedSize(10000)
          + ", reduction="
          + getCompressionRatio(10000)
          + "%";
    }
  }

  static final class ZipCompressor extends AbstractCompressor {
    ZipCompressor() {
      super("ZIP");
    }

    public int estimateCompressedSize(int n) {
      return Math.max(0, (int) Math.round(n * .55));
    }
  }

  static final class UltraLzmaCompressor extends AbstractCompressor {
    UltraLzmaCompressor() {
      super("LZMA");
    }

    public int estimateCompressedSize(int n) {
      return Math.max(0, (int) Math.round(n * .30) + 128);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new ZipCompressor());
    System.out.println(new UltraLzmaCompressor());
  }
}
