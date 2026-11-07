package semester1.practice06;

public class Ex8 {
  static class Student {
    String name;
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    Student first = new Student();
    first.name = "Іван";
    Student second = first;
    second.name = "Петро";
    System.out.println(first.name);
    System.out.println("Обидві змінні посилаються на один об'єкт: " + (first == second));
  }
}
