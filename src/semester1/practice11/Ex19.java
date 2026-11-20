package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex19 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    ArrayList<String> cart = new ArrayList<>();
    printState(cart);
    cart.addAll(List.of("Хліб", "Молоко", "Сир", "Кава"));
    printState(cart);
    cart.clear();
    printState(cart);
    System.out.println("clear() занулює посилання й скидає size до 0. Ємність зберігається.");
  }

  private static void printState(List<String> cart) {
    System.out.printf("Кошик: %s, порожній: %s, розмір: %d%n", cart, cart.isEmpty(), cart.size());
  }
}
