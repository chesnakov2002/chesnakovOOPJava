package ru.academits.chesnakov;

import java.util.Objects;

import static java.util.Objects.hash;

public class ListItem<T> {
    private T data;
    private ListItem<T> next;

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListItem<?> listItem = (ListItem<?>) o;
        return Objects.equals(data, listItem.data) && Objects.equals(next, listItem.next);
    }

    @Override
    public int hashCode() {
        return hash(data, next);
    }
}
