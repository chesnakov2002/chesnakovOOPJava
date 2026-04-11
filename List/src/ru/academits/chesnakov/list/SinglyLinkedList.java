package ru.academits.chesnakov.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private ListItem<E> head;
    private int count;

    public SinglyLinkedList() {
    }

    private void validateNotEmpty() {
        if (count == 0) {
            throw new NoSuchElementException("Список пуст");
        }
    }

    private int findCount(ListItem<E> head) {
        int itemsCount = 0;

        for (ListItem<E> item = head; item != null; item = item.getNext()) {
            itemsCount++;
        }

        return itemsCount;
    }

    private void validateIndex(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Выход за границы списка. Переданный индекс = " + index + " Размер списка = " + count);
        }
    }

    public int getCount() {
        return count;
    }

    public E getHeadData() {
        validateNotEmpty();

        return head.getData();
    }

    public E getData(int index) {
        validateIndex(index);

        int i = 0;
        ListItem<E> item = head;

        while (i != index) {
            item = item.getNext();
            i++;

        }

        return item.getData();
    }

    public E setData(int index, E data) {
        validateIndex(index);

        int i = 0;
        ListItem<E> item = head;

        while (i != index) {
            item = item.getNext();
            i++;
        }

        E removedData = item.getData();
        item.setData(data);

        return removedData;
    }

    public E removeElement(int index) {
        validateIndex(index);

        if (index == 0) {
            ListItem<E> itemToDelete = head;
            head = head.getNext();
            count--;

            return itemToDelete.getData();
        }

        int i = 0;
        ListItem<E> item = head;
        ListItem<E> prevItem = null;

        while (i != index) {
            prevItem = item;
            item = item.getNext();
            i++;
        }

        prevItem.setNext(item.getNext());
        count--;

        return item.getData();
    }

    public void addFirst(E data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, E data) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Выход за границы списка. Переданный индекс = " + index + " Размер списка = " + count);
        }

        if (index == 0) {
            addFirst(data);

            return;
        }

        int i = 0;
        ListItem<E> prevItem = null;
        ListItem<E> item = head;

        while (i != index) {
            prevItem = item;
            item = item.getNext();
            i++;
        }

        ListItem<E> newItem = new ListItem<>(data, item);
        prevItem.setNext(newItem);

        count++;
    }

    public boolean removeByData(E data) {
        if (count == 0) {
            return false;
        }

        int i = 0;
        ListItem<E> item = head;

        if (data == null) {
            while (i < count && item.getData() != null) {
                item = item.getNext();
                i++;
            }
        } else {
            while (i < count && !data.equals(item.getData())) {
                item = item.getNext();
                i++;

            }
        }

        if (i == count) {
            return false;
        }

        removeElement(i);

        return true;
    }

    public E removeFirstElement() {
        validateNotEmpty();

        return removeElement(0);
    }

    public void reverseList() {
        ListItem<E> previousItem = null;
        ListItem<E> currentItem = head;

        while (currentItem.getNext() != null) {
            ListItem<E> nextItem = currentItem.getNext();
            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = nextItem;
        }

        head = previousItem;
    }

    public SinglyLinkedList<E> copy() {
        if (count == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<E> newList = new SinglyLinkedList<>();

        int i = 0;

        for (ListItem<E> sourceItem = head; sourceItem != null; sourceItem = sourceItem.getNext()) {
            newList.add(i, sourceItem.getData());
            i++;
        }

        return newList;
    }
}