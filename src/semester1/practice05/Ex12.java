package semester1.practice05;


public class Ex12 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
      int[] students = {1042, 2031, 3055, 4018, 5099};
      System.out.print("Номер квитка: ");
      int target = scanner.nextInt(), index = -1;
      for (int i = 0; i < students.length; i++) {
        if (students[i] == target) {
          index = i;
          break;
        }
      }
      System.out.println(index < 0 ? "Студента з таким номером не знайдено" : "Індекс: " + index);
    }
  }
}
