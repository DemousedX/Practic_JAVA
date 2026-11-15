package semester1.practice10;

public class Ex13 {

  interface AcousticSignal {
    default String emitAlert() {
      return "Звукова сирена 110 дБ";
    }
  }

  interface OpticalSignal {
    default String emitAlert() {
      return "Стробоскопічний маячок";
    }
  }

  static class EmergencyBeacon implements AcousticSignal, OpticalSignal {
    @Override
    public String emitAlert() {
      return AcousticSignal.super.emitAlert() + " + " + OpticalSignal.super.emitAlert();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    System.out.println(new EmergencyBeacon().emitAlert());
  }
}
