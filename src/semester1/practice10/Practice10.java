package semester1.practice10;

public class Practice10 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    if (args.length > 0) {
      try {
        run(Integer.parseInt(args[0]));
      } catch (NumberFormatException e) {
        System.out.println("Вкажіть номер завдання від 1 до 40");
      }
      return;
    }
    for (int i = 1; i <= 40; i++) {
      if ((i - 1) % 8 == 0) System.out.println("\nБлок " + ((i - 1) / 8 + 1));
      run(i);
    }
  }

  private static void run(int number) {
    System.out.println("\nЗавдання " + number);
    switch (number) {
      case 1 -> Ex1.main(new String[0]);
      case 2 -> Ex2.main(new String[0]);
      case 3 -> Ex3.main(new String[0]);
      case 4 -> Ex4.main(new String[0]);
      case 5 -> Ex5.main(new String[0]);
      case 6 -> Ex6.main(new String[0]);
      case 7 -> Ex7.main(new String[0]);
      case 8 -> Ex8.main(new String[0]);
      case 9 -> Ex9.main(new String[0]);
      case 10 -> Ex10.main(new String[0]);
      case 11 -> Ex11.main(new String[0]);
      case 12 -> Ex12.main(new String[0]);
      case 13 -> Ex13.main(new String[0]);
      case 14 -> Ex14.main(new String[0]);
      case 15 -> Ex15.main(new String[0]);
      case 16 -> Ex16.main(new String[0]);
      case 17 -> Ex17.main(new String[0]);
      case 18 -> Ex18.main(new String[0]);
      case 19 -> Ex19.main(new String[0]);
      case 20 -> Ex20.main(new String[0]);
      case 21 -> Ex21.main(new String[0]);
      case 22 -> Ex22.main(new String[0]);
      case 23 -> Ex23.main(new String[0]);
      case 24 -> Ex24.main(new String[0]);
      case 25 -> Ex25.main(new String[0]);
      case 26 -> Ex26.main(new String[0]);
      case 27 -> Ex27.main(new String[0]);
      case 28 -> Ex28.main(new String[0]);
      case 29 -> Ex29.main(new String[0]);
      case 30 -> Ex30.main(new String[0]);
      case 31 -> Ex31.main(new String[0]);
      case 32 -> Ex32.main(new String[0]);
      case 33 -> Ex33.main(new String[0]);
      case 34 -> Ex34.main(new String[0]);
      case 35 -> Ex35.main(new String[0]);
      case 36 -> Ex36.main(new String[0]);
      case 37 -> Ex37.main(new String[0]);
      case 38 -> Ex38.main(new String[0]);
      case 39 -> Ex39.main(new String[0]);
      case 40 ->
          System.out.println(
              "Фінальна перевірка: скомпілюйте проєкт, запустіть приклади та перевірте git status"
                  + " перед комітом і push");
      default -> System.out.println("Невідоме завдання");
    }
  }
}
