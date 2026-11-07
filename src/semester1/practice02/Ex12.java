package semester1.practice02;

import java.util.Locale;

public final class Ex12 {
  private Ex12() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 12 ---%n");
    String login = "ivan.petrenko", domain = "gmail.com", role = "student";
    String email = login + "@" + domain;
    System.out.println("Користувач " + login + " (роль: " + role + ") має пошту: " + email);
  }
}
