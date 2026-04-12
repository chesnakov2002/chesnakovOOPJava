package ru.academits.chesnakov.list_main;

import ru.academits.chesnakov.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();

        list1.addFirst(1);
        list1.add(1, 3);
        list1.addFirst(5);

        list1.add(2, 5);

        list1.add(0, 2);

        System.out.println(list1);

        System.out.println("Размер односвязного списка = " + list1.getCount());

        System.out.println("Успешная вставка. Замененный элемент = " + list1.setData(0, 10));

        System.out.println(list1);

        list1.removeFirst();

        list1.remove(1);

        int value = 10;

        if (list1.removeByData(value)) {
            System.out.println("Успешное удаление элемента со значением 5.");
        } else {
            System.out.println("Неудачное удаление. Элемента со значением " + value + " не найдено.");
        }

        System.out.println(list1);

        list1.add(list1.getCount(), 11);

        System.out.println("Текущий список = " + list1);

        list1.reverseList();

        System.out.println("Список после разворота = " + list1);

        SinglyLinkedList<Integer> list2 = list1.copy();
        System.out.println("Копия первого списка = " + list2);

        System.out.println("Значениие удаленного элемента с указанным индексом = " + list2.remove(0));

        System.out.println("Значение первого элемента в списке2 = " + list2.getHeadData());

        System.out.println("Значаение последнего элемента списка 2 = " + list2.getData(list2.getCount() - 1));
    }
}
