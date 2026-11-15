package semester1.practice10;

public class Ex17 {

  abstract static class AbstractBird {
    protected final String species;
    protected double weightKg;

    AbstractBird(String species, double weightKg) {
      this.species = species;
      this.weightKg = weightKg;
    }

    public abstract String makeSound();
  }

  interface FlyableUnit {
    double getFlightSpeedKmh();
  }

  interface SwimmingUnit {
    double getDiveDepthMeters();
  }

  static class Falcon extends AbstractBird implements FlyableUnit {
    Falcon() {
      super("Сокіл", 1.2);
    }

    @Override
    public String makeSound() {
      return "Кі-кі";
    }

    @Override
    public double getFlightSpeedKmh() {
      return 100;
    }
  }

  static class EmperorPenguin extends AbstractBird implements SwimmingUnit {
    EmperorPenguin() {
      super("Імператорський пінгвін", 30);
    }

    @Override
    public String makeSound() {
      return "Кра-кр";
    }

    @Override
    public double getDiveDepthMeters() {
      return 500;
    }
  }

  static class CargoPlane implements FlyableUnit {
    @Override
    public double getFlightSpeedKmh() {
      return 850;
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    Falcon falcon = new Falcon();
    EmperorPenguin penguin = new EmperorPenguin();
    for (AbstractBird b : new AbstractBird[] {falcon, penguin})
      System.out.println(b.species + ": " + b.makeSound());
    for (FlyableUnit f : new FlyableUnit[] {falcon, new CargoPlane()})
      System.out.println("Швидкість польоту: " + f.getFlightSpeedKmh());
    System.out.println("Глибина пірнання: " + penguin.getDiveDepthMeters());
  }
}
