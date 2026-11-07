package semester1.practice06;

public class Ex10 {
  static class Animal {
    String species, name;

    public void makeSound() {
      System.out.println(name + " видає звук!");
    }

    public void printInfo() {
      System.out.println(species + ": " + name);
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Animal a = new Animal(), b = new Animal();
    a.species = "Кіт";
    a.name = "Мурчик";
    b.species = "Собака";
    b.name = "Рекс";
    for (Animal v : new Animal[] {a, b}) {
      v.printInfo();
      v.makeSound();
    }
  }
}
