package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import semester1.ConsoleOutput;

public class Task5StalkerBackpackAndSidorovichLoot {
  private static final double MAX_SAFE_RADIATION = 50.0;
  private static final int RARE_ARTIFACT_COST = 15_000;

  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    var backpack = new ArrayList<Artifact>();
    backpack.add(new Artifact("Бенгальський вогонь", 9_500, 14.5));
    backpack.add(new Artifact("Фоняча Пустушка", 0, 92.0));
    backpack.add(new Artifact("Крівник", 18_500, 26.0));
    backpack.add(new Artifact("Аномальний Шлак", 1_200, 135.4));
    backpack.add(new Artifact("Виверт", 11_000, 18.0));
    backpack.add(new Artifact("Іржава Пустушка", 500, 78.5));
    backpack.add(new Artifact("Компас", 45_000, 32.0));
    backpack.add(new Artifact("Граві", 14_000, 21.0));

    System.out.println("Рюкзак Скіфа після рейду");
    for (Artifact artifact : backpack) System.out.println(artifact);
    System.out.printf(Locale.ROOT, "Знахідок: %d, сумарний фон: %.1f мкЗв/год%n",
        backpack.size(), totalRadiation(backpack));

    demonstrateUnsafeRemoval(new ArrayList<>(backpack));
    int removed = purgeRadioactiveDudsWithIterator(backpack, MAX_SAFE_RADIATION);
    System.out.printf(Locale.ROOT, "Вилучено: %d, залишилося: %d, сумарний фон: %.1f мкЗв/год%n",
        removed, backpack.size(), totalRadiation(backpack));

    rankByCost(backpack);
    ArrayList<Artifact> leadSpecialContainer = new ArrayList<>();
    ArrayList<Artifact> standardBeltContainer = new ArrayList<>();
    for (Artifact artifact : backpack) {
      if (artifact.getCostKarbovanets() >= RARE_ARTIFACT_COST) {
        leadSpecialContainer.add(artifact);
      } else {
        standardBeltContainer.add(artifact);
      }
    }
    printContainer("Свинцевий спецконтейнер", leadSpecialContainer);
    printContainer("Стандартний підсумок", standardBeltContainer);
    printReceipt(backpack);
  }

  private static void demonstrateUnsafeRemoval(List<Artifact> backpack) {
    try {
      for (Artifact artifact : backpack) {
        if (artifact.isRadioactiveDud(MAX_SAFE_RADIATION)) backpack.remove(artifact);
      }
    } catch (ConcurrentModificationException e) {
      System.out.println("ConcurrentModificationException при видаленні в for-each");
    }
  }

  public static int purgeRadioactiveDudsWithIterator(List<Artifact> backpack, double maxSafeRadiation) {
    int removed = 0;
    Iterator<Artifact> iterator = backpack.iterator();
    while (iterator.hasNext()) {
      Artifact current = iterator.next();
      if (current.isRadioactiveDud(maxSafeRadiation)) {
        System.out.println("Викинуто через Iterator.remove(): " + current);
        iterator.remove();
        removed++;
      }
    }
    return removed;
  }

  private static void rankByCost(ArrayList<Artifact> artifacts) {
    for (int position = 0; position < artifacts.size() - 1; position++) {
      int bestIndex = position;
      for (int index = position + 1; index < artifacts.size(); index++) {
        if (artifacts.get(index).getCostKarbovanets() > artifacts.get(bestIndex).getCostKarbovanets()) {
          bestIndex = index;
        }
      }
      Artifact best = artifacts.get(bestIndex);
      artifacts.set(bestIndex, artifacts.get(position));
      artifacts.set(position, best);
    }
  }

  private static double totalRadiation(List<Artifact> artifacts) {
    double total = 0;
    for (Artifact artifact : artifacts) total += artifact.getRadiationLevel();
    return total;
  }

  private static void printContainer(String label, List<Artifact> artifacts) {
    System.out.printf("%n%s (%d шт.)%n", label, artifacts.size());
    for (Artifact artifact : artifacts) System.out.println("  " + artifact);
  }

  private static void printReceipt(List<Artifact> artifacts) {
    System.out.println("\nЧек Сидоровича");
    int maxCost = Integer.MIN_VALUE;
    Artifact mostValuable = null;
    long total = 0;
    for (int i = 0; i < artifacts.size(); i++) {
      Artifact artifact = artifacts.get(i);
      int cost = artifact.getCostKarbovanets();
      total += cost;
      if (cost > maxCost) {
        maxCost = cost;
        mostValuable = artifact;
      }
      System.out.printf("%d. %s%n", i + 1, artifact);
    }
    if (mostValuable != null) System.out.println("Найдорожчий артефакт: " + mostValuable.getName());
    System.out.println("Загальний виторг: " + total + " крб");
  }

  public static class Artifact {
    private final String name;
    private final int costKarbovanets;
    private final double radiationLevel;

    public Artifact(String name, int costKarbovanets, double radiationLevel) {
      this.name = name;
      this.costKarbovanets = costKarbovanets;
      this.radiationLevel = radiationLevel;
    }

    public String getName() {
      return name;
    }

    public int getCostKarbovanets() {
      return costKarbovanets;
    }

    public double getRadiationLevel() {
      return radiationLevel;
    }

    public boolean isRadioactiveDud(double maxSafeRadiation) {
      return radiationLevel > maxSafeRadiation || costKarbovanets <= 0;
    }

    @Override
    public String toString() {
      return String.format(Locale.ROOT, "%s — %d крб, %.1f мкЗв/год",
          name, costKarbovanets, radiationLevel);
    }
  }
}
