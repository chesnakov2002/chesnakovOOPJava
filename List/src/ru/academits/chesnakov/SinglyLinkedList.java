package ru.academits.chesnakov;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
        this.count =;
    }

    public SinglyLinkedList(ListItem<T> head, int count) {
        this.head = head;
        this.count = count;
    }

    public int findCount(ListItem<T> head) {
        int count = 1;

        while (head != null) {
            count++;
            head = null;
        }
    }

    public int getCount() {
        return count;
    }

    public
}
