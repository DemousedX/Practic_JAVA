package semester1.practice05;


public class Ex9 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    int[] temps = {18, 21, 15, 24, 13, 27, 20};
    int min = temps[0], max = temps[0], minIndex = 0, maxIndex = 0;
    for (int i = 1; i < temps.length; i++) {
      if (temps[i] < min) {
        min = temps[i];
        minIndex = i;
      }
      if (temps[i] > max) {
        max = temps[i];
        maxIndex = i;
      }
    }
    System.out.println("Мінімум: " + min + ", індекс " + minIndex);
    System.out.println("Максимум: " + max + ", індекс " + maxIndex);
  }
}
