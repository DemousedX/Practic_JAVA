package semester1.practice09;

public class Ex2 {
  static class LabMeasurement {
    private final String experimentName;
    private final double[] samples;

    public LabMeasurement(String experimentName, double[] samples) {
      this.experimentName = experimentName;
      this.samples =
          samples == null ? new double[0] : java.util.Arrays.copyOf(samples, samples.length);
    }

    public double[] getSamples() {
      return java.util.Arrays.copyOf(samples, samples.length);
    }

    public String toString() {
      return experimentName + " | " + java.util.Arrays.toString(samples);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    double[] samples = {1.2, 2.4, 3.6};
    LabMeasurement m = new LabMeasurement("Дослід", samples);
    samples[0] = 99;
    System.out.println(m);
    double[] copy = m.getSamples();
    copy[1] = 99;
    System.out.println(m);
    System.out.println(new LabMeasurement("Порожній", null));
  }
}
