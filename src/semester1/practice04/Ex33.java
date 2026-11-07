package semester1.practice04;

public class Ex33 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (int i = 1; i <= 50; i++) {
      int percent = (int) (((double) i / 50) * 100);
      System.out.println("Завантажено: " + percent + "%");
    }
  }
}
