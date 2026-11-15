package semester1.practice10;

public class Ex9 {

  interface Measurable {
    double getMeasure();
  }

  static class BankVault implements Measurable {
    private final double goldKg;

    BankVault(double v) {
      goldKg = v;
    }

    @Override
    public double getMeasure() {
      return goldKg;
    }
  }

  static class HighwayRoute implements Measurable {
    private final double lengthKm;

    HighwayRoute(double v) {
      lengthKm = v;
    }

    @Override
    public double getMeasure() {
      return lengthKm;
    }
  }

  static class CpuCore implements Measurable {
    private final double frequencyGhz;

    CpuCore(double v) {
      frequencyGhz = v;
    }

    @Override
    public double getMeasure() {
      return frequencyGhz;
    }
  }

  public static double computeAverage(Measurable[] items) {
    if (items.length == 0) throw new IllegalArgumentException("Порожній масив");
    double sum = 0;
    for (Measurable item : items) sum += item.getMeasure();
    return sum / items.length;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    System.out.println(
        "Середнє значення: "
            + computeAverage(
                new Measurable[] {new BankVault(100), new HighwayRoute(200), new CpuCore(3.6)}));
  }
}
