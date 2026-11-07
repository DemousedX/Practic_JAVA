package semester1.practice02;

import java.util.Locale;

public final class Ex15 {
  private Ex15() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 15 ---%n");
    String protocol = "https://", host = "api.example.com", endpoint = "/users";
    int userId = 42;
    System.out.println("Запит відправлено на: " + protocol + host + endpoint + "/" + userId);
  }
}
