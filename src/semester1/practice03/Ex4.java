package semester1.practice03;

public class Ex4 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner =
        new java.util.Scanner(System.in).useLocale(java.util.Locale.US)) {
      System.out.print("Номер квитка: ");
      int id = scanner.nextInt();
      scanner.nextLine();
      System.out.print("Повне ім'я: ");
      String name = scanner.nextLine();
      System.out.print("Спеціальність: ");
      String major = scanner.nextLine();
      System.out.println("Студент: " + name + ", квиток N" + id + ", спеціальність: " + major);
    }
  }
}
