package semester1.practice06;

public class Ex9 {
  static class Greeter {
    public void sayHello() {
      System.out.println("Привіт усім!");
    }

    public void sayHelloTo(String name) {
      System.out.println("Привіт, " + name + "! Раді тебе бачити");
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Greeter g = new Greeter();
    g.sayHello();
    g.sayHelloTo("Олександр");
  }
}
