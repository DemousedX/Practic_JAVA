package semester1.practice10;

public class Ex29 {

  static class MediaItem {
    final String title;
    final double sizeMb;

    MediaItem(String title, double sizeMb) {
      this.title = title;
      this.sizeMb = sizeMb;
    }
  }

  static class VideoFile extends MediaItem {
    final int resolutionHeight, durationSec;

    VideoFile(String title, double sizeMb, int resolutionHeight, int durationSec) {
      super(title, sizeMb);
      this.resolutionHeight = resolutionHeight;
      this.durationSec = durationSec;
    }

    boolean is4K() {
      return resolutionHeight >= 2160;
    }
  }

  static class AudioFile extends MediaItem {
    final int bitrateKbps;

    AudioFile(String title, double sizeMb, int bitrateKbps) {
      super(title, sizeMb);
      this.bitrateKbps = bitrateKbps;
    }

    boolean isLossless() {
      return bitrateKbps >= 1000;
    }
  }

  static class EBookFile extends MediaItem {
    final int pageCount;

    EBookFile(String title, double sizeMb, int pageCount) {
      super(title, sizeMb);
      this.pageCount = pageCount;
    }
  }

  static double highQualitySize(MediaItem[] items) {
    double total = 0;
    for (MediaItem m : items)
      if ((m instanceof VideoFile v && v.is4K()) || (m instanceof AudioFile a && a.isLossless())) {
        total += m.sizeMb;
        System.out.println(m.title);
      }
    return total;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    MediaItem[] items = {
      new VideoFile("Фільм 4K", 8000, 2160, 7200),
      new VideoFile("Кліп HD", 100, 1080, 180),
      new AudioFile("FLAC", 40, 1411),
      new AudioFile("MP3", 5, 320),
      new EBookFile("Java", 10, 500)
    };
    System.out.println("Сумарний обсяг: " + highQualitySize(items) + " МБ");
  }
}
