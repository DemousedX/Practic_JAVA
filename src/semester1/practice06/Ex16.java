package semester1.practice06;

public class Ex16 {
  static class Printer {
    String model;
    int paperCount;

    public void printDocument(String title, int pages) {
      if (pages <= 0) return;
      if (pages > paperCount) {
        System.out.println("Помилка: Недостатньо паперу в принтері " + model + "!");
        return;
      }
      paperCount -= pages;
      System.out.println(
          "Надруковано " + title + ": " + pages + " сторінок, залишилось " + paperCount);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Printer p = new Printer();
    p.model = "Canon";
    p.paperCount = 10;
    p.printDocument("Звіт", 6);
    p.printDocument("Документ", 8);
  }
}
