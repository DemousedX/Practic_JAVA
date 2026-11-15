package semester1.practice10;

public class Ex16 {

  interface DataExportable {
    String toJson();

    String toCsvRow();
  }

  static String jsonString(String s) {
    StringBuilder result = new StringBuilder("\"");
    for (char c : s.toCharArray()) {
      if (c == '\\' || c == '"') result.append('\\').append(c);
      else if (c < 32) result.append(String.format("\\u%04x", (int) c));
      else result.append(c);
    }
    return result.append('"').toString();
  }

  static String csvString(String s) {
    return "\"" + s.replace("\"", "\"\"") + "\"";
  }

  static class StudentGradeRecord implements DataExportable {
    private final String name;
    private final int group;
    private final double gpa;

    StudentGradeRecord(String name, int group, double gpa) {
      this.name = name;
      this.group = group;
      this.gpa = gpa;
    }

    @Override
    public String toJson() {
      return "{\"name\":" + jsonString(name) + ",\"group\":" + group + ",\"gpa\":" + gpa + "}";
    }

    @Override
    public String toCsvRow() {
      return csvString(name) + "," + group + "," + gpa;
    }
  }

  static class WeatherObservation implements DataExportable {
    private final String city;
    private final double tempC;
    private final int humidity;

    WeatherObservation(String city, double tempC, int humidity) {
      this.city = city;
      this.tempC = tempC;
      this.humidity = humidity;
    }

    @Override
    public String toJson() {
      return "{\"city\":"
          + jsonString(city)
          + ",\"tempC\":"
          + tempC
          + ",\"humidity\":"
          + humidity
          + "}";
    }

    @Override
    public String toCsvRow() {
      return csvString(city) + "," + tempC + "," + humidity;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    DataExportable[] records = {
      new StudentGradeRecord("Олександр", 11, 4.8), new WeatherObservation("Київ", 12.5, 65)
    };
    System.out.println("JSON:");
    String[] json = new String[records.length];
    for (int i = 0; i < records.length; i++) json[i] = records[i].toJson();
    System.out.println("[" + String.join(",", json) + "]");
    System.out.println("CSV (назва,група або температура,бал або вологість):");
    for (DataExportable r : records) System.out.println(r.toCsvRow());
  }
}
