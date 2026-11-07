package semester1.practice08;

public final class Ex15 {
  private Ex15() {}

  static class Publication {
    private String title, author;
    private int releaseYear;

    Publication(String title, String author, int year) {
      this.title = title;
      this.author = author;
      releaseYear = year;
    }

    @Override
    public String toString() {
      return title + " by " + author + " (" + releaseYear + ")";
    }
  }

  static class PrintedBook extends Publication {
    private int pages;
    private String cover;

    PrintedBook(String title, String author, int year, int pages, String cover) {
      super(title, author, year);
      this.pages = pages;
      this.cover = cover;
    }

    @Override
    public String toString() {
      return "PrintedBook{" + super.toString() + ", pages=" + pages + ", cover=" + cover + "}";
    }
  }

  static class AudioBook extends Publication {
    private int durationMinutes;
    private String narrator;

    AudioBook(String title, String author, int year, int duration, String narrator) {
      super(title, author, year);
      durationMinutes = duration;
      this.narrator = narrator;
    }

    public String formatDuration() {
      return durationMinutes / 60 + " год " + durationMinutes % 60 + " хв";
    }

    @Override
    public String toString() {
      return "AudioBook{"
          + super.toString()
          + ", duration="
          + formatDuration()
          + ", narrator="
          + narrator
          + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 15 ---%n");

    System.out.println(new PrintedBook("Кобзар", "Тарас Шевченко", 1840, 256, "hardcover"));
    System.out.println(new AudioBook("Місто", "Валер'ян Підмогильний", 1928, 385, "Олег"));
  }
}
