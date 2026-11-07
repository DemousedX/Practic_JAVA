package semester1.practice08;

public final class Ex32 {
  private Ex32() {}

  static class Medicine {
    protected String name;
    protected double price;
    protected boolean expired;

    Medicine(String name, double price, boolean expired) {
      this.name = name;
      this.price = Math.max(0, price);
      this.expired = expired;
    }

    public boolean canSell(boolean hasPrescription) {
      return !expired;
    }

    @Override
    public String toString() {
      return name + ", price=" + price + ", expired=" + expired;
    }
  }

  static class PrescriptionMedicine extends Medicine {
    private String doctorLicense;

    PrescriptionMedicine(String name, double price, boolean expired, String license) {
      super(name, price, expired);
      doctorLicense = license;
    }

    @Override
    public boolean canSell(boolean hasPrescription) {
      return super.canSell(hasPrescription) && hasPrescription && !doctorLicense.isBlank();
    }
  }

  static class ControlledSubstance extends PrescriptionMedicine {
    private int patientAge;

    ControlledSubstance(String name, double price, boolean expired, String license, int age) {
      super(name, price, expired, license);
      patientAge = age;
    }

    @Override
    public boolean canSell(boolean hasPrescription) {
      return super.canSell(hasPrescription) && patientAge >= 18;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 32 ---%n");

    ControlledSubstance medicine =
        new ControlledSubstance("Rx medicine", 450, false, "LIC-552", 20);
    System.out.println(medicine + ", sale allowed=" + medicine.canSell(true));
    System.out.println("Без рецепта: " + medicine.canSell(false));
    System.out.println(
        "Неповнолітній: " + new ControlledSubstance("Rx", 450, false, "LIC-552", 17).canSell(true));
    System.out.println(
        "Прострочено: " + new ControlledSubstance("Rx", 450, true, "LIC-552", 20).canSell(true));
  }
}
