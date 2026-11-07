package semester1.practice02;

import java.util.Locale;

public final class Ex31 {
  private Ex31() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 31 ---%n");
    boolean hasPassword = true, hasSmsCode = true, isAccountBlocked = false;
    boolean canLogin = hasPassword && hasSmsCode && !isAccountBlocked;
    System.out.println("Доступ дозволено: " + canLogin);
  }
}
