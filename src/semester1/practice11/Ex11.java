package semester1.practice11;

import java.util.Arrays;

import semester1.ConsoleOutput;

public class Ex11 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    Object[] oldData = new Object[10];
    for (int i = 0; i < oldData.length; i++) oldData[i] = i + 1;
    Object[] newData = growArrayManually(oldData);
    newData[10] = 11;
    System.out.println("Старий: " + Arrays.toString(oldData));
    System.out.println("Розширений: " + Arrays.toString(newData));
    System.arraycopy(newData, 2, newData, 3, 11 - 2);
    newData[2] = 99;
    System.out.println("Після вставки: " + Arrays.toString(newData));
  }

  public static Object[] growArrayManually(Object[] oldData) {
    Object[] newData = new Object[oldData.length + Math.max(1, oldData.length / 2)];
    System.arraycopy(oldData, 0, newData, 0, oldData.length);
    return newData;
  }
}
