package semester1.practice08;

public class Ex21 {
  static class Parcel {
    private String trackingCode;
    private double weightKg;

    public Parcel(String trackingCode, double weightKg) {
      this.trackingCode = trackingCode;
      this.weightKg = Math.max(0, weightKg);
    }

    public double calculateShippingCost() {
      return 50 + weightKg * 12;
    }

    public String toString() {
      return trackingCode + " | " + weightKg + " kg | " + calculateShippingCost() + " грн";
    }
  }

  static class FragileParcel extends Parcel {
    private boolean requiresWoodenBox;
    private double insuranceValue;

    public FragileParcel(
        String trackingCode, double weightKg, boolean requiresWoodenBox, double insuranceValue) {
      super(trackingCode, weightKg);
      this.requiresWoodenBox = requiresWoodenBox;
      this.insuranceValue = Math.max(0, insuranceValue);
    }

    @Override
    public double calculateShippingCost() {
      return super.calculateShippingCost() + insuranceValue * 0.015 + (requiresWoodenBox ? 120 : 0);
    }

    @Override
    public String toString() {
      return super.toString()
          + " | обрешітка: "
          + requiresWoodenBox
          + " | страхова вартість: "
          + insuranceValue;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new Parcel("UA1", 2.5));
    System.out.println(new FragileParcel("UA2", 2.5, true, 2000));
  }
}
