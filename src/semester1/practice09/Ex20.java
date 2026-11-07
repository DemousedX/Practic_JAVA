package semester1.practice09;

public class Ex20 {
  static class AudioTrack {
    private final String title, artist;
    private final int durationSeconds;

    public AudioTrack(String title, String artist, int durationSeconds) {
      this.title = title;
      this.artist = artist;
      this.durationSeconds = Math.max(0, durationSeconds);
    }

    public String formatDuration() {
      return String.format("%02d:%02d", durationSeconds / 60, durationSeconds % 60);
    }

    public String toString() {
      return title + " | " + artist + " | " + formatDuration();
    }
  }

  static class Playlist {
    private String name;
    private final AudioTrack[] tracks;
    private int trackCount;

    public Playlist(String name, int capacity) {
      this.name = name;
      tracks = new AudioTrack[capacity];
    }

    public void addTrack(AudioTrack track) {
      if (track != null && trackCount < tracks.length) tracks[trackCount++] = track;
    }

    public int getTotalDurationSeconds() {
      int sum = 0;
      for (int i = 0; i < trackCount; i++) sum += tracks[i].durationSeconds;
      return sum;
    }

    public String toString() {
      StringBuilder s = new StringBuilder(name).append('\n');
      for (int i = 0; i < trackCount; i++) s.append(tracks[i]).append('\n');
      int seconds = getTotalDurationSeconds();
      return s.append(seconds / 60).append(" хв ").append(seconds % 60).append(" сек").toString();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Playlist p = new Playlist("Focus", 5);
    p.addTrack(new AudioTrack("Intro", "Artist", 187));
    p.addTrack(new AudioTrack("Night", "Band", 241));
    System.out.println(p);
  }
}
