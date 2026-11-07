package semester1.practice08;

public class Ex24 {
  static class Coffee {
    private String roastType;
    private int volumeMl;
    private double basePrice;

    public Coffee(String roastType, int volumeMl, double basePrice) {
      this.roastType = roastType;
      this.volumeMl = volumeMl;
      this.basePrice = basePrice;
    }

    public double calculateCalories() {
      return volumeMl * 0.01;
    }

    public double calculatePrice() {
      return basePrice;
    }

    public String toString() {
      return roastType
          + " | "
          + volumeMl
          + " ml | "
          + calculateCalories()
          + " kcal | "
          + calculatePrice()
          + " грн";
    }
  }

  static class LatteWithAddons extends Coffee {
    private String milkType;
    private int syrupPumps;

    public LatteWithAddons(
        String roastType, int volumeMl, double basePrice, String milkType, int syrupPumps) {
      super(roastType, volumeMl, basePrice);
      this.milkType = milkType;
      this.syrupPumps = Math.max(0, syrupPumps);
    }

    @Override
    public double calculateCalories() {
      return super.calculateCalories() + 100 + syrupPumps * 20;
    }

    @Override
    public double calculatePrice() {
      return super.calculatePrice()
          + (milkType.equalsIgnoreCase("рослинне") ? 20 : 0)
          + syrupPumps * 12;
    }

    @Override
    public String toString() {
      return super.toString() + " | молоко: " + milkType + " | сироп: " + syrupPumps;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new Coffee("Середнє обсмаження", 200, 60));
    System.out.println(new LatteWithAddons("Середнє обсмаження", 300, 80, "рослинне", 2));
  }
}
