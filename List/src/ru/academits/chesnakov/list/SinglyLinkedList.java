package ru.academits.chesnakov.list;

import java.util.NoSuchElementException;
import java.util.Objects;

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

    private void validateIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Переданный индекс = " + index
                    + ". Индекс должен быть не меньше 0 и строго меньше " + count + '.');
        }
    }

    private ListItem<E> getCurrentItemByIndex(int index) {
        int i = 0;
        ListItem<E> item = head;

        while (i != index) {
            item = item.getNext();
            i++;
        }

        return item;
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

        return getCurrentItemByIndex(index).getData();
    }

    public E setData(int index, E data) {
        validateIndex(index);

        ListItem<E> item = getCurrentItemByIndex(index);

        E removedData = item.getData();
        item.setData(data);

        return removedData;
    }

    public E remove(int index) {
        validateIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<E> previousItem = getCurrentItemByIndex(index - 1);
        ListItem<E> currentItem = previousItem.getNext();

        previousItem.setNext(currentItem.getNext());
        count--;

        return currentItem.getData();
    }

    public void addFirst(E data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, E data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Переданный индекс = " + index
                    + ". Индекс должен быть не меньше 0 и не больше " + count + '.');
        }

        if (index == 0) {
            addFirst(data);

            return;
        }

        ListItem<E> previousItem = getCurrentItemByIndex(index - 1);
        ListItem<E> currentItem = previousItem.getNext();

        previousItem.setNext(new ListItem<>(data, currentItem));

        count++;
    }

    public boolean removeByData(E data) {
        if (count == 0) {
            return false;
        }

        ListItem<E> currentItem = head;
        ListItem<E> previousItem = null;

        while (currentItem != null) {
            if (Objects.equals(data, currentItem.getData())) {
                if (previousItem == null) {
                    removeFirst();

                    return true;
                }

                previousItem.setNext(currentItem.getNext());

                count--;

                return true;
            }

            previousItem = currentItem;
            currentItem = currentItem.getNext();
        }

        return false;
    }

    public E removeFirst() {
        validateNotEmpty();

        E dataToDelete = head.getData();
        head = head.getNext();
        count--;

        return dataToDelete;
    }

    public void reverse() {
        ListItem<E> previousItem = null;
        ListItem<E> currentItem = head;

        while (currentItem != null) {
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

        for (ListItem<E> sourceItem = head; sourceItem != null; sourceItem = sourceItem.getNext()) {
            newList.addFirst(sourceItem.getData());
        }

        newList.reverse();

        return newList;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder("{");

        ListItem<E> item = head;

        for (; item != null; item = item.getNext()) {
            stringBuilder.append(item.getData())
                    .append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length())
                .append('}');

        return stringBuilder.toString();
    }
}