package semester1.practice11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import semester1.ConsoleOutput;

public class Ex38 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    List<String> receiptLines = List.of("Хліб: 35", "Молоко: 48", "Помилка сканера: N/A",
        "Кава: 240", "Пакет: 5", "Сир: 185");
    List<Integer> prices = parsePrices(receiptLines);
    long total = 0;
    Iterator<Integer> it = prices.iterator();
    while (it.hasNext()) {
      int price = it.next();
      if (price < 40) {
        it.remove();
      } else {
        total += price;
      }
    }
    System.out.println("Ціни від 40 грн: " + prices);
    System.out.println("До сплати: " + total + " грн");
  }

  public static ArrayList<Integer> parsePrices(List<String> receiptLines) {
    var prices = new ArrayList<Integer>();
    for (String line : receiptLines) {
      int separator = line.indexOf(':');
      if (separator < 0) {
        System.out.println("Пропущено рядок: " + line);
        continue;
      }
      try {
        prices.add(Integer.parseInt(line.substring(separator + 1).trim()));
      } catch (NumberFormatException e) {
        System.out.println("Пропущено рядок: " + line);
      }
    }
    return prices;
  }
}
