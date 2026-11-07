package semester1.practice04;

public class Ex37 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Висота і ширина: ");
      int h = scanner.nextInt(), w = scanner.nextInt();
      if (h < 1 || w < 1) {
        System.out.println("Розміри мають бути додатними");
        return;
      }
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          System.out.print(i == 0 || i == h - 1 || j == 0 || j == w - 1 ? "*" : " ");
        }
        System.out.println();
      }
    }
  }
}
