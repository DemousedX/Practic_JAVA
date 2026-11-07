package semester1.practice05;


public class Ex16 {
  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    String[] cities = {"Київ", "Львів", "Харків", "Одеса", "Дніпро"};
    for (String city : cities) {
      System.out.println("Ласкаво просимо до міста " + city + "!");
    }
  }
}
