package semester1.practice05;


public class Ex37 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    String[][] weekSchedule = {
      {"Вища математика", "Основи програмування", "Фізика"},
      {"Англійська мова", "Історія України"},
      {"Основи програмування", "Основи програмування", "Бази даних", "Фізвиховання"},
      {"Дискретна математика"},
      {"Філософія", "Основи алгоритмізації", "Практикум"}
    };
    String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця"};
    for (int i = 0; i < weekSchedule.length; i++) {
      System.out.println(days[i] + ", пар: " + weekSchedule[i].length);
      for (String subject : weekSchedule[i]) {
        System.out.println(subject);
      }
    }
  }
}
