package semester1.practice07;

public class Ex23 {
  static class SalaryCalculator {
    public double calculate(double baseRate) {
      return baseRate;
    }

    public double calculate(double baseRate, double fixedBonus) {
      return baseRate + fixedBonus;
    }

    public double calculate(double baseRate, double bonusPercent, boolean isTaxDeducted) {
      return baseRate * (1 + bonusPercent / 100) * (isTaxDeducted ? 0.805 : 1);
    }

    public double calculate(double baseRate, int overtimeHours, double overtimeHourlyRate) {
      return baseRate + overtimeHours * overtimeHourlyRate;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    SalaryCalculator s = new SalaryCalculator();
    System.out.println(s.calculate(30000));
    System.out.println(s.calculate(30000, 2000));
    System.out.println(s.calculate(30000, 15, true));
    System.out.println(s.calculate(30000, 10, 250));
  }
}
