package semester1.practice09;

import java.util.Arrays;

public final class Ex39 {
  private Ex39() {}

  abstract static class AbstractFilter {
    private final String filterName;

    AbstractFilter(String n) {
      filterName = n;
    }

    public abstract double processSample(double x);

    public String toString() {
      return filterName;
    }
  }

  static final class AmplifierFilter extends AbstractFilter {
    private final double gain;

    AmplifierFilter(double g) {
      super("AmplifierFilter");
      gain = g;
    }

    public double processSample(double x) {
      return x * gain;
    }
  }

  static final class ClippingFilter extends AbstractFilter {
    private final double threshold;

    ClippingFilter(double t) {
      super("ClippingFilter");
      threshold = Math.abs(t);
    }

    public double processSample(double x) {
      return Math.max(-threshold, Math.min(threshold, x));
    }
  }

  static final class SignalProcessor {
    private final AbstractFilter[] pipeline;
    private int count;

    SignalProcessor(int n) {
      pipeline = new AbstractFilter[n];
    }

    public void add(AbstractFilter f) {
      if (f != null && count < pipeline.length) pipeline[count++] = f;
    }

    public double[] process(double[] signal) {
      double[] result = signal.clone();
      for (int i = 0; i < result.length; i++)
        for (int j = 0; j < count; j++) result[i] = pipeline[j].processSample(result[i]);
      return result;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    var p = new SignalProcessor(3);
    p.add(new AmplifierFilter(4));
    p.add(new ClippingFilter(10));
    double[] signal = {-.5, 1, 4};
    System.out.println(Arrays.toString(p.process(signal)));
  }
}
