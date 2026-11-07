package semester1.practice09.homework;

import java.util.Arrays;

public final class Ex2 {
  private abstract static class AbstractHardwareComponent {
    private final String name, category;
    private final double watts, score, price;

    AbstractHardwareComponent(
        String name, String category, double watts, double score, double price) {
      this.name = name;
      this.category = category;
      this.watts = watts;
      this.score = score;
      this.price = price;
    }

    String getCategory() {
      return category;
    }

    double getPowerWatts() {
      return watts;
    }

    double getBenchmarkScore() {
      return score;
    }

    double getPrice() {
      return price;
    }

    @Override
    public String toString() {
      return String.format("[%s] %s (%.0f W | score %.1f)", category, name, watts, score);
    }
  }

  private static final class ProcessorUnit extends AbstractHardwareComponent {
    private final String socket;

    ProcessorUnit(String name, String socket, double watts, double score, double price) {
      super(name, "CPU", watts, score, price);
      this.socket = socket;
    }

    String getSocket() {
      return socket;
    }
  }

  private static final class GraphicsCard extends AbstractHardwareComponent {
    GraphicsCard(String name, double watts, double score, double price) {
      super(name, "GPU", watts, score, price);
    }
  }

  private static final class NvmeSsdDrive extends AbstractHardwareComponent {
    private final double[] speedSamples;

    NvmeSsdDrive(String name, double[] speeds, double price) {
      super(name, "NVMe SSD", 12, Arrays.stream(speeds.clone()).average().orElse(0) * .25, price);
      speedSamples = speeds.clone();
    }

    double[] getSpeedSamples() {
      return speedSamples.clone();
    }
  }

  private static final class Motherboard {
    private final String model, socket;
    private final int maxExpansionSlots;

    Motherboard(String model, String socket, int slots) {
      this.model = model;
      this.socket = socket;
      maxExpansionSlots = slots;
    }

    int getMaxExpansionSlots() {
      return maxExpansionSlots;
    }

    boolean isSocketCompatible(String cpuSocket) {
      return socket.equals(cpuSocket);
    }
  }

  private static final class PowerSupplyUnit {
    private final String model;
    private final double ratedWatts, efficiency;

    PowerSupplyUnit(String model, double watts, double efficiency) {
      this.model = model;
      ratedWatts = watts;
      this.efficiency = efficiency;
    }

    double getSafeContinuousWatts() {
      return ratedWatts * .85;
    }

    double getEfficiency() {
      return efficiency;
    }
  }

  private static final class WorkstationPC {
    private final String buildName;
    private final Motherboard motherboard;
    private final PowerSupplyUnit psu;
    private final AbstractHardwareComponent[] components;
    private int componentCount;

    WorkstationPC(String name, Motherboard motherboard, PowerSupplyUnit psu) {
      buildName = name;
      this.motherboard = motherboard;
      this.psu = psu;
      components = new AbstractHardwareComponent[motherboard.getMaxExpansionSlots()];
    }

    boolean installComponent(AbstractHardwareComponent component) {
      if (component == null || componentCount >= components.length) return false;
      if (component instanceof ProcessorUnit cpu
          && !motherboard.isSocketCompatible(cpu.getSocket())) {
        System.out.println("Socket mismatch; component rejected");
        return false;
      }
      if (getTotalPowerWatts() + component.getPowerWatts() > psu.getSafeContinuousWatts()) {
        System.out.println("Power limit exceeded; component rejected");
        return false;
      }
      components[componentCount++] = component;
      System.out.println("Installed: " + component);
      return true;
    }

    double getTotalPowerWatts() {
      double total = 0;
      for (int i = 0; i < componentCount; i++) total += components[i].getPowerWatts();
      return total;
    }

    double getTotalSystemScore() {
      double total = 0;
      for (int i = 0; i < componentCount; i++) total += components[i].getBenchmarkScore();
      return total;
    }

    double getTotalBuildPrice() {
      double total = 0;
      for (int i = 0; i < componentCount; i++) total += components[i].getPrice();
      return total;
    }

    @Override
    public String toString() {
      return String.format(
          "Build '%s'%nMotherboard: %s%nPSU: %s (safe %.0f W, efficiency %.0f%%)%nComponents:"
              + " %s%nLoad: %.0f W%nScore: %.1f%nPrice: %.2f грн",
          buildName,
          motherboard.model,
          psu.model,
          psu.getSafeContinuousWatts(),
          psu.getEfficiency() * 100,
          Arrays.toString(Arrays.copyOf(components, componentCount)),
          getTotalPowerWatts(),
          getTotalSystemScore(),
          getTotalBuildPrice());
    }
  }

  private void runTask() {
    Motherboard board = new Motherboard("ASUS ROG B650", "AM5", 4);
    PowerSupplyUnit psu = new PowerSupplyUnit("Seasonic 750W Gold", 750, .90);
    WorkstationPC pc = new WorkstationPC("DeepLearning-Rig", board, psu);
    pc.installComponent(new ProcessorUnit("Intel Core i9", "LGA1700", 170, 10000, 22000));
    pc.installComponent(new ProcessorUnit("AMD Ryzen 9 7950X", "AM5", 170, 10944, 26000));
    pc.installComponent(new GraphicsCard("NVIDIA RTX 4080 Super", 320, 4828, 48000));
    NvmeSsdDrive ssd =
        new NvmeSsdDrive("Samsung 990 Pro 2TB", new double[] {7400, 7520, 7410}, 7900);
    double[] speeds = ssd.getSpeedSamples();
    speeds[0] = 0;
    pc.installComponent(ssd);
    System.out.println(pc);
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    new Ex2().runTask();
  }
}
