package ru.academits.chesnakov;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
        count = findCount(head);
    }

    public SinglyLinkedList(ListItem<T> head, int count) {
        this.head = head;
        this.count = count;
    }

    private void validateNotEmpty() {
        if (count == 0) {
            throw new NoSuchElementException("Список пуст");
        }
    }

    private int findCount(ListItem<T> head) {
        int itemCount = 0;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            itemCount++;
        }

        return itemCount;
    }

    private void validateIndex(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Выход за границы списка. Переданный индекс = " + index + " Размер списка = " + count);
        }
    }

    public int getCount() {
        return count;
    }

    public T getHeadData() {
        validateNotEmpty();

        return head.getData();
    }

    public T getData(int index) {
        validateIndex(index);

        int i = 0;
        ListItem<T> item = head;

        while (i != index) {
            item = item.getNext();
            i++;

        }

        return item.getData();
    }

    public T setData(int index, T data) {
        validateIndex(index);

        int i = 0;
        ListItem<T> item = head;

        while (i != index) {
            item = item.getNext();
            i++;
        }

        T removedData = item.getData();
        item.setData(data);

        return removedData;
    }

    public T removeElement(int index) {
        validateIndex(index);

        if (index == 0) {
            ListItem<T> itemToDelete = head;
            head = head.getNext();
            count--;

            return itemToDelete.getData();
        }

        int i = 0;
        ListItem<T> item = head;
        ListItem<T> prevItem = null;

        while (i != index) {
            prevItem = item;
            item = item.getNext();
            i++;

        }

        prevItem.setNext(item.getNext());
        count--;

        return item.getData();
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Выход за границы списка. Переданный индекс = " + index + " Размер списка = " + count);
        }

        if (index == 0) {
            addFirst(data);

            return;
        }

        int i = 0;
        ListItem<T> prevItem = null;
        ListItem<T> item = head;

        while (i != index) {
            prevItem = item;
            item = item.getNext();
            i++;

        }

        ListItem<T> newItem = new ListItem<>(data, item);
        prevItem.setNext(newItem);

        count++;
    }

    public boolean removeByData(T data) {
        if (count == 0) {
            return false;
        }

        int i = 0;
        ListItem<T> item = head;

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

    public T removeFirstElement() {
        validateNotEmpty();

        return removeElement(0);
    }

    public void reverseList() {
        int i = 0;
        ListItem<T> prevItem = null;
        ListItem<T> item = head;
        ListItem<T> nextItem;

        while (i < count) {
            nextItem = item.getNext();
            item.setNext(prevItem);
            prevItem = item;
            item = nextItem;
            i++;
        }

        head = prevItem;
    }

    public SinglyLinkedList<T> copyList() {
        if (this.count == 0) {
            return new SinglyLinkedList<>(null, 0);
        }

        ListItem<T> newHead = new ListItem<>(head.getData(), null);
        ListItem<T> prevItem = newHead;

        for (ListItem<T> item = head.getNext(); item != null; item = item.getNext(), prevItem = prevItem.getNext()) {
            ListItem<T> newItem = new ListItem<>(item.getData(), null);
            prevItem.setNext(newItem);
        }

        return new SinglyLinkedList<>(newHead);
    }
}