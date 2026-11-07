package semester1.practice08;

public final class Ex10 {
  private Ex10() {}

  static class Animal {
    private String name;
    private int age;
    private double weight;

    Animal(String name, int age, double weight) {
      this.name = name;
      this.age = Math.max(0, age);
      this.weight = Math.max(0, weight);
    }

    public String details() {
      return name + ", age=" + age + ", weight=" + weight;
    }
  }

  static class Dog extends Animal {
    private String breed;

    Dog(String name, int age, double weight, String breed) {
      super(name, age, weight);
      this.breed = breed;
    }

    public String fetchStick() {
      return breed + " brings the stick";
    }

    @Override
    public String toString() {
      return "Dog{" + details() + ", breed='" + breed + "'}";
    }
  }

  static class Cat extends Animal {
    private boolean indoor;

    Cat(String name, int age, double weight, boolean indoor) {
      super(name, age, weight);
      this.indoor = indoor;
    }

    public String purr() {
      return "Purr!";
    }

    @Override
    public String toString() {
      return "Cat{" + details() + ", indoor=" + indoor + "}";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.printf("%n--- Практична N8, завдання 10 ---%n");

    Dog dog = new Dog("Рекс", 4, 18, "Labrador");
    Cat cat = new Cat("Мурка", 3, 4.2, true);
    System.out.println(dog + " - " + dog.fetchStick());
    System.out.println(cat + " - " + cat.purr());
  }
}
