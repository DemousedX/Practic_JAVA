package semester1.practice07;

public class Ex1 {
  static class Book {
    private String title, author;
    private int year;
    private double price;

    public Book() {
      this("Невідомо", "Невідомий", 2000, 0);
    }

    public Book(String title, String author, int year, double price) {
      this.title = title;
      this.author = author;
      this.year = year < 0 ? 2000 : year;
      this.price = Math.max(0, price);
    }

    public void printInfo() {
      System.out.printf("%s | %s | %d | %.2f грн%n", title, author, year, price);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new Book().printInfo();
    new Book("Кобзар", "Тарас Шевченко", 1840, 250).printInfo();
    new Book("Книга", "Автор", -1, -50).printInfo();
  }
}
