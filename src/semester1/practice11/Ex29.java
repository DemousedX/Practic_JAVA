package semester1.practice11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import semester1.ConsoleOutput;

public class Ex29 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<String> array = new ArrayList<>(List.of("Java", "SQL", "Git"));
    System.out.println("ArrayList, індекс 1: " + array.get(1));
    LinkedList<String> linked = new LinkedList<>();
    linked.addFirst("Початок");
    linked.addLast("Кінець");
    System.out.println("LinkedList: " + linked);
    Vector<String> vector = new Vector<>();
    vector.addElement("Синхронізований список");
    System.out.println("Vector: " + vector.elementAt(0));
    Stack<String> books = new Stack<>();
    books.push("Кобзар");
    books.push("Лісова пісня");
    books.push("Місто");
    System.out.println("Верхівка: " + books.peek());
    while (!books.isEmpty()) {
      System.out.println("Зі стека: " + books.pop());
    }
  }
}
