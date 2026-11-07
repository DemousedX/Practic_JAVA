package semester1.practice07;

public class Ex36 {
  static class Processor {
    String model;
    double frequencyGHz, price;

    public Processor(String model, double frequencyGHz, double price) {
      this.model = model;
      this.frequencyGHz = frequencyGHz;
      this.price = price;
    }

    public double getPrice() {
      return price;
    }
  }

  static class Memory {
    int sizeGB, frequencyMHz;
    double price;

    public Memory(int sizeGB, int frequencyMHz, double price) {
      this.sizeGB = sizeGB;
      this.frequencyMHz = frequencyMHz;
      this.price = price;
    }

    public double getPrice() {
      return price;
    }
  }

  static class Computer {
    String title;
    Processor cpu;
    Memory ram;
    double casePrice;

    public Computer(String title, Processor cpu, Memory ram, double casePrice) {
      this.title = title;
      this.cpu = cpu;
      this.ram = ram;
      this.casePrice = casePrice;
    }

    public double calculateTotalPrice() {
      return cpu.getPrice() + ram.getPrice() + casePrice;
    }

    public void upgradeMemory(Memory newRam) {
      if (newRam != null) {
        ram = newRam;
        System.out.println("Оперативну пам'ять замінено");
      }
    }

    public void printSpecs() {
      System.out.printf(
          "%s | %s %.1f GHz | %d GB %d MHz | %.2f грн%n",
          title, cpu.model, cpu.frequencyGHz, ram.sizeGB, ram.frequencyMHz, calculateTotalPrice());
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Computer c =
        new Computer("ПК", new Processor("Ryzen 5", 3.6, 6000), new Memory(16, 3200, 1800), 2000);
    c.printSpecs();
    c.upgradeMemory(new Memory(32, 3200, 3000));
    c.printSpecs();
  }
}
