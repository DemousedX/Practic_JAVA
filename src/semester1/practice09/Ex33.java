package semester1.practice09;

public class Ex33 {
  abstract static class AbstractPcPart {
    private final String model;
    private final double priceUah;

    public AbstractPcPart(String model, double priceUah) {
      this.model = model;
      this.priceUah = priceUah;
    }

    public abstract int getPowerConsumptionWatts();

    public String toString() {
      return model + " | " + priceUah + " грн | " + getPowerConsumptionWatts() + " W";
    }
  }

  static class ProcessorPart extends AbstractPcPart {
    int cores, watts;

    public ProcessorPart(String model, double priceUah, int cores, int watts) {
      super(model, priceUah);
      this.cores = cores;
      this.watts = watts;
    }

    @Override
    public int getPowerConsumptionWatts() {
      return watts;
    }
  }

  static class VideoCardPart extends AbstractPcPart {
    int vramGb, watts;

    public VideoCardPart(String model, double priceUah, int vramGb, int watts) {
      super(model, priceUah);
      this.vramGb = vramGb;
      this.watts = watts;
    }

    @Override
    public int getPowerConsumptionWatts() {
      return watts;
    }
  }

  static class DesktopPC {
    private final int psuMaxWatts;
    private final AbstractPcPart[] parts;
    private int count;

    public DesktopPC(int psuMaxWatts, int capacity) {
      this.psuMaxWatts = psuMaxWatts;
      parts = new AbstractPcPart[capacity];
    }

    public void addPart(AbstractPcPart part) {
      if (part != null && count < parts.length) parts[count++] = part;
    }

    public int getTotalPower() {
      int sum = 0;
      for (int i = 0; i < count; i++) sum += parts[i].getPowerConsumptionWatts();
      return sum;
    }

    public boolean isStable() {
      return getTotalPower() * 1.2 <= psuMaxWatts;
    }

    public String toString() {
      return java.util.Arrays.toString(java.util.Arrays.copyOf(parts, count))
          + " | total="
          + getTotalPower()
          + " W | PSU="
          + psuMaxWatts
          + " W | stable="
          + isStable();
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    for (int psu : new int[] {350, 500}) {
      DesktopPC p = new DesktopPC(psu, 4);
      p.addPart(new ProcessorPart("Ryzen 7", 12000, 8, 105));
      p.addPart(new VideoCardPart("RTX 4070", 25000, 12, 200));
      System.out.println(p);
    }
  }
}
