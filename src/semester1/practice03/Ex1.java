package semester1.practice03;

public class Ex1 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Ім'я: ");
      String name = scanner.nextLine();
      System.out.print("Прізвище: ");
      String surname = scanner.nextLine();
      System.out.print("Вік: ");
      int age = scanner.nextInt();
      scanner.nextLine();
      System.out.print("Місто: ");
      String city = scanner.nextLine();
      System.out.println("=== ВХІДНІ ДАНІ ===");
      System.out.println(
          "Ім'я: " + name + "\nПрізвище: " + surname + "\nВік: " + age + "\nМісто: " + city);
      System.out.println(
          "Привіт, " + name + " " + surname + " з міста " + city + "! Твій вік: " + age);
    }
  }
}
