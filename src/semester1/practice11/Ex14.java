package semester1.practice11;

import java.util.Objects;

import semester1.ConsoleOutput;

public class Ex14 {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    SimpleArrayList list = new SimpleArrayList();
    System.out.println("Початкова ємність: " + list.getCapacity());
    for (int i = 1; i <= 12; i++) list.add(i);
    System.out.printf("Розмір: %d, ємність: %d, останній: %s%n",
        list.size(), list.getCapacity(), list.get(11));
  }

  public static class SimpleArrayList {
    private Object[] data = new Object[10];
    private int size;

    public void add(Object element) {
      if (size == data.length) {
        Object[] expanded = new Object[data.length + data.length / 2];
        System.arraycopy(data, 0, expanded, 0, size);
        data = expanded;
      }
      data[size++] = element;
    }

    public Object get(int index) {
      return data[Objects.checkIndex(index, size)];
    }

    public int size() {
      return size;
    }

    public int getCapacity() {
      return data.length;
    }
  }
}
