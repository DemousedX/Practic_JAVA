package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.Objects;
import semester1.ConsoleOutput;

public class Task2ArrayListCapacityAndDynamicGrowth {
  public static void main(String[] args) {
    ConsoleOutput.useUtf8();
    var emulator = new CustomArrayCapacityEmulator<String>();
    var mixedList = new ArrayList<>();
    mixedList.add("Block");
    mixedList.add(42);
    // var і порожні <> виводять ArrayList<Object>, тому типи елементів можна змішувати.
    System.out.println("Приклад ArrayList<Object>: " + mixedList);
    System.out.println("Початкова ємність: " + emulator.getCapacity());
    for (int i = 1; i <= 35; i++) {
      int before = emulator.getCapacity();
      emulator.add("Block-" + i);
      if (before != emulator.getCapacity()) {
        System.out.printf("Елемент %d: %d -> %d%n", i, before, emulator.getCapacity());
      }
    }
    emulator.add(0, "HEADER");
    System.out.println("Перший елемент: " + emulator.get(0));
    System.out.println("Видалено з індексу 5: " + emulator.remove(5));
    System.out.printf("Розмір: %d, ємність: %d, розширень: %d, скопійовано: %d%n",
        emulator.size(), emulator.getCapacity(), emulator.getResizeCount(),
        emulator.getTotalElementsCopied());
    emulator.trimToSize();
    System.out.println("Ємність після trimToSize(): " + emulator.getCapacity());
  }

  public static class CustomArrayCapacityEmulator<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData = new Object[DEFAULT_CAPACITY];
    private int size;
    private int resizeCount;
    private long totalElementsCopied;

    private void ensureCapacityInternal() {
      if (size < elementData.length) return;
      int oldCapacity = elementData.length;
      int growth = Math.max(1, oldCapacity >> 1);
      int newCapacity = (int) Math.min(Integer.MAX_VALUE, (long) oldCapacity + growth);
      if (newCapacity == oldCapacity) throw new OutOfMemoryError("Масив досяг максимальної ємності");
      Object[] newBuffer = new Object[newCapacity];
      System.arraycopy(elementData, 0, newBuffer, 0, size);
      elementData = newBuffer;
      resizeCount++;
      totalElementsCopied += size;
    }

    public void add(E element) {
      ensureCapacityInternal();
      elementData[size++] = element;
    }

    public void add(int index, E element) {
      if (index < 0 || index > size) throw new IndexOutOfBoundsException(index);
      ensureCapacityInternal();
      System.arraycopy(elementData, index, elementData, index + 1, size - index);
      elementData[index] = element;
      size++;
    }

    public E remove(int index) {
      E removed = get(index);
      int moved = size - index - 1;
      if (moved > 0) System.arraycopy(elementData, index + 1, elementData, index, moved);
      elementData[--size] = null;
      return removed;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
      return (E) elementData[Objects.checkIndex(index, size)];
    }

    public E set(int index, E element) {
      E old = get(index);
      elementData[index] = element;
      return old;
    }

    public int size() {
      return size;
    }

    public int getCapacity() {
      return elementData.length;
    }

    public int getResizeCount() {
      return resizeCount;
    }

    public long getTotalElementsCopied() {
      return totalElementsCopied;
    }

    public void trimToSize() {
      if (size == elementData.length) return;
      Object[] compact = new Object[size];
      System.arraycopy(elementData, 0, compact, 0, size);
      elementData = compact;
    }
  }
}
