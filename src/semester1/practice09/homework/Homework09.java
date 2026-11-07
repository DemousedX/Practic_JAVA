package semester1.practice09.homework;

public final class Homework09 {
  private Homework09() {}

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    if (args.length != 1) {
      System.out.println("Вкажіть номер завдання від 1 до 5");
      return;
    }
    switch (Integer.parseInt(args[0])) {
      case 1 -> Ex1.main(new String[0]);
      case 2 -> Ex2.main(new String[0]);
      case 3 -> Ex3.main(new String[0]);
      case 4 -> Ex4.main(new String[0]);
      case 5 -> Ex5.main(new String[0]);
      default -> System.out.println("Невідоме завдання");
    }
  }
}
