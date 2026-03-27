package ru.academits.chesnakov;

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

    public boolean isEmpty() {
        return count == 0;
    }

    public int findCount(ListItem<T> head) {
        count = 0;

        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            count++;
        }

        return count;
    }

    public void validateIndex(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Выход за границы списка. Переданный индекс = " + index + " Размер списка = " + count);
        }
    }

    public int getCount() {
        return count;
    }

    public T getHeadData(ListItem<T> head) {
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
        if (isEmpty()) {
            return false;
        }

        int i = 0;
        ListItem<T> item = head;

        if (data == null) {
            while (i < count && item.getData() != null) {
                item = item.getNext();
                i++;

            }

            if (i == count) {
                return false;
            }

            removeElement(i);

            return true;
        }

        while (i < count && !data.equals(item.getData())) {
            item = item.getNext();
            i++;

        }

        if (i == count) {
            return false;
        }

        removeElement(i);

        return true;
    }
}
