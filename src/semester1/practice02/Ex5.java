package semester1.practice02;

import java.util.Locale;

public final class Ex5 {
  private Ex5() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Locale.setDefault(Locale.US);

    System.out.printf("%n--- Практична N2, завдання 05 ---%n");
    boolean isJavaFun = true, isFishFly = false, isSkyBlue = true;
    System.out.println(isJavaFun);
    System.out.println(isFishFly);
    System.out.println(isSkyBlue);
  }
}
