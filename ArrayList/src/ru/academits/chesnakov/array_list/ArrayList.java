package ru.academits.chesnakov.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] items;
    private int size;
    private int modCount;

    public ArrayList(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива. Переданный индекс = " + index);
        }
    }

    @Override
    public boolean contains(Object o) {
        for (E e : items) {
            if (Objects.equals(e, o)) {
                return true;
            }
        }

        return false;
    }

    private class MyIterator implements Iterator<E> {
        private int currentIndex = -1;
        private final int iteratorModCount = ArrayList.this.modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Выход за размеры коллекции. Текущий размер коллекции = " + size);
            }

            if (iteratorModCount != ArrayList.this.modCount) {
                throw new ConcurrentModificationException("За время обхода в коллекцию добавили или удалили элементы." +
                        "Текущее количество модификаций = " + ArrayList.this.modCount);
            }

            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (size > a.length) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(items, size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, size);

        if (size < a.length) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(E e) {
        if (size >= items.length) {
            increaseCapacity();
        }

        items[size] = e;
        size++;
        modCount++;

        return true;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, size * 2);
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, items[i])) {
                if (i == size - 1) {
                    items[i] = null;

                } else {
                    while (i < size - 1) {
                        items[i] = items[i + 1];
                        i++;
                    }

                    items[size - 1] = null;
                }

                size--;
                modCount++;

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }

        for (E e : c) {
            this.add(e);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива. Переданный индекс = " + index);
        }

        if (c.isEmpty()) {
            return false;
        }

        while (items.length < size + c.size()) {
            increaseCapacity();
        }

        for (int i = size - 1; i >= index; i--) {
            items[i + c.size()] = items[i];
        }

        int i = index;

        for (E e : c) {
            items[i] = e;
            i++;
        }

        size += c.size();
        modCount++;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (this.isEmpty()) {
            return false;
        }

        boolean changed = false;

        for (int i = 0; i < size; i++) {
            if (c.contains(items[i])) {
                remove(items[i]);

                changed = true;
                i--;
            }
        }

        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (this.isEmpty()) {
            return false;
        }

        boolean changed = false;

        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(items[i]);

                changed = true;
                i--;
            }
        }

        return changed;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
        modCount++;
    }

    @Override
    public E get(int index) {
        validateIndex(index);

        return items[index];
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);

        E oldItem = items[index];
        items[index] = element;

        return oldItem;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива. Переданный индекс = " + index);
        }

        if (index == size) {
            add(element);

            return;
        }

        if (size == items.length) {
            increaseCapacity();
        }

        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];

        }

        items[index] = element;

        size++;
        modCount++;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);

        E itemToDelete = items[index];

        if (index == size - 1) {
            items[index] = null;
        } else {
            for (int i = index; i < size - 1; i++) {
                items[i] = items[i + 1];
            }

            items[size - 1] = null;
        }

        size--;
        modCount++;

        return itemToDelete;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    // не нужно
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    // не нужно
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    // не нужно
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
