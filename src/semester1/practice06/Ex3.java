package semester1.practice06;

public class Ex3 {
  static class Book {
    String title, author;
    int pages;
    boolean isRead;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Book emptyBook = new Book();
    System.out.println(
        emptyBook.title
            + ", "
            + emptyBook.author
            + ", "
            + emptyBook.pages
            + ", "
            + emptyBook.isRead);
  }
}
