package semester1.practice10;

public class Ex33 {

  static class FinalCalibrationTable {
    public static final double GRAVITY_G = 9.80665;
    private final String sensorSerial;
    private final double[] coefficients;

    FinalCalibrationTable(String serial, double[] coefficients) {
      sensorSerial = serial;
      this.coefficients = java.util.Arrays.copyOf(coefficients, coefficients.length);
    }

    public String getSensorSerial() {
      return sensorSerial;
    }

    public double[] getCoefficients() {
      return java.util.Arrays.copyOf(coefficients, coefficients.length);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    final double[] mutable = {1, 2};
    mutable[0] = 7;
    System.out.println("final масив дозволяє зміну елемента: " + mutable[0]);
    double[] source = {1, 2, 3};
    FinalCalibrationTable table = new FinalCalibrationTable("S-01", source);
    source[0] = 99;
    double[] copy = table.getCoefficients();
    copy[1] = 99;
    System.out.println(
        table.getSensorSerial() + ": " + java.util.Arrays.toString(table.getCoefficients()));
    System.out.println("g=" + FinalCalibrationTable.GRAVITY_G);
    // table.sensorSerial = "S-02"; // final поле не можна переприсвоїти

  }
}
