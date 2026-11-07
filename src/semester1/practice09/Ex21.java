package semester1.practice09;

public class Ex21 {
  static class ServerNode {
    private final String ipAddress;
    private final int totalRamGb;
    private int usedRamGb;
    private boolean online = true;

    public ServerNode(String ipAddress, int totalRamGb) {
      this.ipAddress = ipAddress;
      this.totalRamGb = Math.max(0, totalRamGb);
    }

    public int getFreeRamGb() {
      return totalRamGb - usedRamGb;
    }

    public void setOnline(boolean online) {
      this.online = online;
    }

    public boolean allocate(int ram) {
      if (!online || ram <= 0 || ram > getFreeRamGb()) return false;
      usedRamGb += ram;
      return true;
    }

    public String toString() {
      return ipAddress + " | online=" + online + " | free=" + getFreeRamGb() + " GB";
    }
  }

  static class DataCenterCluster {
    private final String clusterLocation;
    private final ServerNode[] nodes;
    private int nodeCount;

    public DataCenterCluster(String clusterLocation, int capacity) {
      this.clusterLocation = clusterLocation;
      nodes = new ServerNode[capacity];
    }

    public void addNode(ServerNode node) {
      if (node != null && nodeCount < nodes.length) nodes[nodeCount++] = node;
    }

    public boolean deployContainer(int requiredRamGb) {
      if (requiredRamGb <= 0) return false;
      for (int i = 0; i < nodeCount; i++) if (nodes[i].allocate(requiredRamGb)) return true;
      return false;
    }

    public String toString() {
      return clusterLocation
          + " | "
          + java.util.Arrays.toString(java.util.Arrays.copyOf(nodes, nodeCount));
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    DataCenterCluster c = new DataCenterCluster("Київ", 3);
    ServerNode offline = new ServerNode("10.0.0.1", 128);
    offline.setOnline(false);
    c.addNode(offline);
    c.addNode(new ServerNode("10.0.0.2", 64));
    System.out.println(c.deployContainer(48));
    System.out.println(c.deployContainer(32));
    System.out.println(c);
  }
}
