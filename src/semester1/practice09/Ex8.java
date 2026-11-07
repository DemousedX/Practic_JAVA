package semester1.practice09;

public class Ex8 {
  static class MedicalRecord {
    private final String patientId;
    private String fullName;
    private int bloodGroup;
    private boolean rhPositive;
    private String[] allergies;

    public MedicalRecord(
        String patientId, String fullName, int bloodGroup, boolean rhPositive, String[] allergies) {
      this.patientId = patientId;
      this.fullName = fullName;
      this.bloodGroup = Math.max(1, Math.min(4, bloodGroup));
      this.rhPositive = rhPositive;
      this.allergies = allergies == null ? new String[0] : allergies.clone();
    }

    public String[] getAllergies() {
      return allergies.clone();
    }

    public boolean hasAllergyTo(String substance) {
      for (String a : allergies) if (a != null && a.equalsIgnoreCase(substance)) return true;
      return false;
    }

    public String toString() {
      String group = new String[] {"I (O)", "II (A)", "III (B)", "IV (AB)"}[bloodGroup - 1];
      return patientId
          + " | "
          + fullName
          + " | "
          + group
          + " Rh"
          + (rhPositive ? "+" : "-")
          + " | "
          + java.util.Arrays.toString(allergies);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    String[] a = {"penicillin"};
    MedicalRecord r = new MedicalRecord("P1", "Олена", 2, true, a);
    a[0] = "other";
    r.getAllergies()[0] = "other";
    System.out.println(r);
    System.out.println(r.hasAllergyTo("Penicillin"));
  }
}
