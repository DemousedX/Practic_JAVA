package semester1.practice10;

public class Ex8 {

  abstract static class IndustrialAsset {
    private final String name;
    protected final double initialCost;
    protected final int usefulLifeYears;

    IndustrialAsset(String name, double cost, int life) {
      if (cost < 0 || life <= 0) throw new IllegalArgumentException("Некоректні параметри");
      this.name = name;
      initialCost = cost;
      usefulLifeYears = life;
    }

    public abstract double getBookValueAfterYears(int years);

    public String getName() {
      return name;
    }
  }

  static class LinearDepreciationAsset extends IndustrialAsset {
    LinearDepreciationAsset(String name, double cost, int life) {
      super(name, cost, life);
    }

    @Override
    public double getBookValueAfterYears(int years) {
      return initialCost * Math.max(0, 1 - Math.max(0, years) / (double) usefulLifeYears);
    }
  }

  static class DecliningBalanceAsset extends IndustrialAsset {
    private final double rate;

    DecliningBalanceAsset(String name, double cost, int life, double rate) {
      super(name, cost, life);
      if (rate < 0 || rate > 1) throw new IllegalArgumentException("Ставка від 0 до 1");
      this.rate = rate;
    }

    @Override
    public double getBookValueAfterYears(int years) {
      return initialCost * Math.pow(1 - rate, Math.max(0, years));
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    IndustrialAsset[] assets = {
      new LinearDepreciationAsset("Верстат", 100000, 10),
      new DecliningBalanceAsset("Прес", 200000, 8, 0.2)
    };
    double total = 0;
    for (IndustrialAsset a : assets) {
      double value = a.getBookValueAfterYears(3);
      total += value;
      System.out.printf("%s: %.2f грн%n", a.getName(), value);
    }
    System.out.printf("Залишкова вартість цеху: %.2f грн%n", total);
  }
}
