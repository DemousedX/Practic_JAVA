package semester1.practice09;

public class Ex19 {
  static class BookItem {
    private final String title, author;
    private final int pages;

    public BookItem(String title, String author, int pages) {
      this.title = title;
      this.author = author;
      this.pages = pages;
    }

    public String toString() {
      return title + " | " + author + " | " + pages;
    }
  }

  static class Bookshelf {
    private final String genre;
    private final BookItem[] books;
    private int bookCount;

    public Bookshelf(String genre, int capacity) {
      this.genre = genre;
      books = new BookItem[capacity];
    }

    public boolean putBook(BookItem book) {
      if (book == null || bookCount == books.length) return false;
      books[bookCount++] = book;
      return true;
    }

    public BookItem findLongestBook() {
      if (bookCount == 0) return null;
      BookItem longest = books[0];
      for (int i = 1; i < bookCount; i++) if (books[i].pages > longest.pages) longest = books[i];
      return longest;
    }

    public int getTotalPagesOnShelf() {
      int sum = 0;
      for (int i = 0; i < bookCount; i++) sum += books[i].pages;
      return sum;
    }

    public String toString() {
      return genre + " | " + java.util.Arrays.toString(java.util.Arrays.copyOf(books, bookCount));
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Bookshelf s = new Bookshelf("Фантастика", 2);
    s.putBook(new BookItem("Дюна", "Френк Герберт", 412));
    s.putBook(new BookItem("Соляріс", "Станіслав Лем", 204));
    System.out.println(s.putBook(null));
    System.out.println(s);
    System.out.println(s.findLongestBook());
    System.out.println(s.getTotalPagesOnShelf());
  }
}
