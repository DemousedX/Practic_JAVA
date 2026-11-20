package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex20 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<String> cities = new ArrayList<>(List.of("Київ", "Львів", "Одеса", "Харків", "Дніпро"));
    Object[] objArray = cities.toArray();
    String[] strArray = cities.toArray(new String[0]);
    System.out.println("Object[]: " + Arrays.toString(objArray));
    System.out.println("String[]: " + Arrays.toString(strArray));
    ArrayList<String> copy = new ArrayList<>(Arrays.asList(strArray));
    System.out.println("Новий ArrayList: " + copy);
  }
}
