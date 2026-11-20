package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;

import semester1.ConsoleOutput;

public class Ex9 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    String[] fixedArray = new String[3];
    fixedArray[0] = "Київ";
    fixedArray[1] = "Львів";
    fixedArray[2] = "Одеса";
    try {
      fixedArray[3] = "Дніпро";
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("У масиві лише три позиції");
    }
    ArrayList<String> dynamicList = new ArrayList<>(Arrays.asList(fixedArray));
    dynamicList.add("Дніпро");
    dynamicList.add("Харків");
    dynamicList.add(1, "Полтава");
    dynamicList.remove(0);
    System.out.println("Масив: " + Arrays.toString(fixedArray));
    System.out.println("Список: " + dynamicList);
  }
}
