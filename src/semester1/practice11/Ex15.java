package semester1.practice11;

import java.util.ArrayList;

import semester1.ConsoleOutput;

public class Ex15 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<String> logs = new ArrayList<>(500);
    System.out.println("Ємність 500 резервує місце й дозволяє уникнути проміжних копіювань");
    logs.add("INFO: Start");
    logs.add("INFO: Done");
    logs.ensureCapacity(1000);
    System.out.println("Після ensureCapacity(1000) розмір: " + logs.size());
    logs.trimToSize();
    System.out.println("trimToSize скорочує резерв до поточного розміру: " + logs.size());
    System.out.println(logs);
  }
}
