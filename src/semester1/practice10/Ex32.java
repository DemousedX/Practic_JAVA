package semester1.practice10;

public class Ex32 {

  static class CargoContainer {
    private final String id;

    CargoContainer(String id) {
      this.id = id;
    }

    public String getId() {
      return id;
    }
  }

  interface HazardousCargo {
    int getHazardClass();
  }

  interface RefrigeratedCargo {
    double getRequiredTempC();
  }

  static class ElectronicsContainer extends CargoContainer {
    ElectronicsContainer(String id) {
      super(id);
    }
  }

  static class ChemicalContainer extends CargoContainer implements HazardousCargo {
    ChemicalContainer(String id) {
      super(id);
    }

    @Override
    public int getHazardClass() {
      return 3;
    }
  }

  static class FrozenFoodContainer extends CargoContainer implements RefrigeratedCargo {
    FrozenFoodContainer(String id) {
      super(id);
    }

    @Override
    public double getRequiredTempC() {
      return -18;
    }
  }

  static void inspect(CargoContainer[] containers) {
    for (CargoContainer c : containers) {
      System.out.println(c.getId());
      boolean special = false;
      if (c instanceof HazardousCargo h) {
        System.out.println("Спецбокс, клас небезпеки " + h.getHazardClass());
        special = true;
      }
      if (c instanceof RefrigeratedCargo r) {
        System.out.println("Живлення рефрижератора, температура " + r.getRequiredTempC());
        special = true;
      }
      if (!special) System.out.println("Звичайний склад");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    inspect(
        new CargoContainer[] {
          new ElectronicsContainer("E-01"),
          new ChemicalContainer("C-01"),
          new FrozenFoodContainer("F-01")
        });
  }
}
