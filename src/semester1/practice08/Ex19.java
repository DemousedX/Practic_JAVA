package semester1.practice08;

public class Ex19 {
  static class Ticket {
    private String eventName;
    private double basePrice;

    public Ticket(String eventName, double basePrice) {
      this.eventName = eventName;
      this.basePrice = basePrice;
    }

    public double getFinalPrice() {
      return basePrice;
    }

    public String toString() {
      return eventName + " | " + getFinalPrice() + " грн";
    }
  }

  static class StudentTicket extends Ticket {
    private String studentCardNumber;

    public StudentTicket(String eventName, double basePrice, String studentCardNumber) {
      super(eventName, basePrice);
      this.studentCardNumber = studentCardNumber;
    }

    @Override
    public double getFinalPrice() {
      return super.getFinalPrice() * 0.5;
    }

    @Override
    public String toString() {
      return super.toString() + " | студентський " + studentCardNumber;
    }
  }

  static class VipTicket extends Ticket {
    private boolean includesBackstage;
    private double loungeFee;

    public VipTicket(
        String eventName, double basePrice, boolean includesBackstage, double loungeFee) {
      super(eventName, basePrice);
      this.includesBackstage = includesBackstage;
      this.loungeFee = loungeFee;
    }

    @Override
    public double getFinalPrice() {
      return super.getFinalPrice() + loungeFee;
    }

    @Override
    public String toString() {
      return super.toString() + " | backstage=" + includesBackstage + " | lounge=" + loungeFee;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(new Ticket("Java Conf", 1200));
    System.out.println(new StudentTicket("Java Conf", 1200, "ST1"));
    System.out.println(new VipTicket("Java Conf", 1200, true, 300));
  }
}
