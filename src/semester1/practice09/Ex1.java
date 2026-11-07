package semester1.practice09;

public class Ex1 {
  static final class ImmutableGeoPoint {
    private final double latitude, longitude;

    public ImmutableGeoPoint(double latitude, double longitude) {
      this.latitude = Math.max(-90, Math.min(90, latitude));
      this.longitude = Math.max(-180, Math.min(180, longitude));
    }

    public double getLatitude() {
      return latitude;
    }

    public double getLongitude() {
      return longitude;
    }

    public ImmutableGeoPoint shift(double dLat, double dLon) {
      return new ImmutableGeoPoint(latitude + dLat, longitude + dLon);
    }

    public String toString() {
      return "(" + latitude + "; " + longitude + ")";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    ImmutableGeoPoint p = new ImmutableGeoPoint(100, -200);
    System.out.println(p);
    System.out.println(p.shift(-10, 20));
    System.out.println(p);
  }
}
