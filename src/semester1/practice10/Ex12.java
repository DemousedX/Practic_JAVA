package semester1.practice10;

public class Ex12 {

  interface DataValidator {
    boolean isValid(String input);

    default String validateOrDefault(String input, String fallback) {
      return isValid(input) ? input : fallback;
    }

    static boolean isNotNullOrBlank(String s) {
      return s != null && !s.isBlank();
    }
  }

  static class EmailValidator implements DataValidator {
    @Override
    public boolean isValid(String s) {
      return DataValidator.isNotNullOrBlank(s) && s.contains("@") && s.contains(".");
    }
  }

  static class PositiveNumberValidator implements DataValidator {
    @Override
    public boolean isValid(String s) {
      if (!DataValidator.isNotNullOrBlank(s)) return false;
      try {
        double value = Double.parseDouble(s);
        return Double.isFinite(value) && value > 0;
      } catch (NumberFormatException e) {
        return false;
      }
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    DataValidator[] validators = {new EmailValidator(), new PositiveNumberValidator()};
    for (DataValidator v : validators)
      for (String input : new String[] {"student@example.com", "42", "-2", null})
        System.out.println(
            v.getClass().getSimpleName() + ": " + v.validateOrDefault(input, "Некоректні дані"));
  }
}
