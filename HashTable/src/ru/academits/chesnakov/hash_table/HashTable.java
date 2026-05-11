package ru.academits.chesnakov.hash_table;

import ru.academits.chesnakov.linked_list.SinglyLinkedList;

import java.util.Collection;
import java.util.Iterator;

public class HashTable<E> implements Collection<E> {
    private SinglyLinkedList<E>[] array;
    private int size;

    public HashTable() {
        this(16);
    }

    public HashTable(Collection<? extends E> c) {
        this(Math.max(16, (int) (c.size() / 0.75) + 1));

        addAll(c);
    }

    public HashTable(int capacity) {
        //noinspection unchecked
        array = (SinglyLinkedList<E>[]) new SinglyLinkedList[capacity];
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
