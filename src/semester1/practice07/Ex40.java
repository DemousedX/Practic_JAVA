package semester1.practice07;

public class Ex40 {
  static class BookItem {
    String isbn, title, author;
    boolean isAvailable;

    public BookItem(String isbn, String title, String author) {
      this.isbn = isbn;
      this.title = title;
      this.author = author;
      isAvailable = true;
    }

    public void borrowBook() {
      if (isAvailable) isAvailable = false;
    }

    public void returnBook() {
      isAvailable = true;
    }

    public void printBook() {
      System.out.println(
          isbn + " | " + title + " | " + author + " | " + (isAvailable ? "Доступна" : "Видана"));
    }
  }

  static class LibraryCatalog {
    private BookItem[] books;
    private int size;

    public LibraryCatalog(int capacity) {
      books = new BookItem[capacity];
    }

    public void addBook(BookItem book) {
      if (book != null && size < books.length) books[size++] = book;
    }

    public BookItem findBookByTitle(String title) {
      for (int i = 0; i < size; i++) if (books[i].title.equals(title)) return books[i];
      return null;
    }

    public boolean borrowBook(String title) {
      BookItem b = findBookByTitle(title);
      if (b == null || !b.isAvailable) return false;
      b.borrowBook();
      return true;
    }

    public void printCatalog() {
      for (int i = 0; i < size; i++) books[i].printBook();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    LibraryCatalog c = new LibraryCatalog(5);
    c.addBook(new BookItem("1", "Кобзар", "Тарас Шевченко"));
    c.addBook(new BookItem("2", "Місто", "Валер'ян Підмогильний"));
    c.addBook(new BookItem("3", "Лісова пісня", "Леся Українка"));
    c.printCatalog();
    System.out.println(c.borrowBook("Кобзар"));
    c.printCatalog();
    System.out.println(c.borrowBook("Кобзар"));
    c.findBookByTitle("Кобзар").returnBook();
    c.printCatalog();
  }
}
