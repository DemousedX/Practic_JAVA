package semester1.practice11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import semester1.ConsoleOutput;

public class Ex27 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    exploreCollectionHierarchy();
  }

  public static void exploreCollectionHierarchy() {
    Object[] examples = {
      new ArrayList<String>(), new LinkedList<String>(), new Vector<String>(),
      new Stack<String>(), new HashSet<String>(), new ArrayDeque<String>()
    };
    for (Object item : examples) {
      System.out.printf("%s: List=%s, Set=%s, Queue=%s, Collection=%s, Iterable=%s%n",
          item.getClass().getSimpleName(), item instanceof List<?>, item instanceof Set<?>,
          item instanceof Queue<?>, item instanceof Collection<?>, item instanceof Iterable<?>);
    }
  }
}
