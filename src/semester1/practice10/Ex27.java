package semester1.practice10;

public class Ex27 {

  abstract static class AbstractWorker {
    private final double basePay;

    AbstractWorker(double basePay) {
      this.basePay = basePay;
    }

    public double getBasePay() {
      return basePay;
    }
  }

  interface BonusEligible {
    double calculateQuarterBonus();
  }

  interface MedicalInsured {
    double getInsuranceCoverage();
  }

  static class FullTimeDeveloper extends AbstractWorker implements BonusEligible, MedicalInsured {
    FullTimeDeveloper(double pay) {
      super(pay);
    }

    @Override
    public double calculateQuarterBonus() {
      return getBasePay() * 0.3;
    }

    @Override
    public double getInsuranceCoverage() {
      return 100000;
    }
  }

  static class FopContractor extends AbstractWorker implements BonusEligible {
    FopContractor(double pay) {
      super(pay);
    }

    @Override
    public double calculateQuarterBonus() {
      return getBasePay() * 0.1;
    }
  }

  static class InternStudent extends AbstractWorker {
    InternStudent(double pay) {
      super(pay);
    }
  }

  public static double[] audit(AbstractWorker[] staff) {
    double payroll = 0, bonuses = 0;
    int insured = 0;
    for (AbstractWorker w : staff) {
      payroll += w.getBasePay();
      if (w instanceof BonusEligible b) bonuses += b.calculateQuarterBonus();
      if (w instanceof MedicalInsured) insured++;
    }
    return new double[] {payroll, bonuses, insured};
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    double[] result =
        audit(
            new AbstractWorker[] {
              new FullTimeDeveloper(50000), new FopContractor(40000), new InternStudent(10000)
            });
    System.out.printf(
        "Фонд оплати: %.2f, премії: %.2f, застраховано: %.0f%n", result[0], result[1], result[2]);
  }
}
