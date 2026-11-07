package semester1.practice05.homework;

public final class Ex2 {
  private Ex2() {}

  private static void inventory() {
    String[] items = {"Ноутбук", "Смартфон", "Навушники", "Клавіатура", "Монітор 27\""};
    int[] q = {8, 3, 25, 4, 12};
    double[] p = {28500, 19200, 1850, 3100, 9400}, values = new double[items.length];
    double sum = 0;
    int max = 0;
    System.out.println("Товар | К-сть | Ціна | Вартість");
    for (int i = 0; i < items.length; i++) {
      values[i] = q[i] * p[i];
      sum += values[i];
      if (values[i] > values[max]) max = i;
      System.out.printf("%s | %d | %.2f | %.2f%n", items[i], q[i], p[i], values[i]);
      if (q[i] < 5) System.out.println(" УВАГА: терміново замовити " + items[i]);
    }
    System.out.printf(
        "Активи складу: %.2f грн%nНайбільший запас у грошах: %s (%.2f грн)%n",
        sum, items[max], values[max]);
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- ДЗ до практичної N5, завдання 2 ---%n");
    inventory();
  }
}
