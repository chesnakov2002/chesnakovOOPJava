package ru.academits.chesnakov.array_list_main;

import ru.academits.chesnakov.array_list.ArrayList;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(5, 3, 5, 8, 4));

        list1.add(1);

        System.out.println("Размер списка1 = " + list1.size());
        System.out.println("Список1 = " + list1);

        System.out.println("В списке1 содержиться элемент 8 = " + list1.contains(8));

        Integer number = 4;

        if (list1.remove(number)) {
            System.out.println("Удаление элемента со значением " + number + " прошло успешно");
        } else {
            System.out.println("Не удалось удалить элемент со значением " + number);
        }

        List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 3, 10, 8));

        if (list1.containsAll(list2)) {
            System.out.println("В списке1 содержаться все элементы списка2");
        } else {
            System.out.println("В списке1 содержаться не все элементы списка2");
        }

        System.out.println("Элемент списка1 с индексом 2 = " + list1.get(2));

        list1.add(2, 21);
        System.out.println("Список1 после добавления элемента 21 по индексу 2 = " + list1);

        Integer removedElement = list1.remove(3);
        System.out.println("Удаленный элемент с индексом 3 = " + removedElement);

        System.out.println("Индекс первого элемента 5 = " + list1.indexOf(5));
        System.out.println("Индекс последнего элемента 5 = " + list1.lastIndexOf(5));
        System.out.println("Индекс элемента 56 = " + list1.indexOf(56));

        Object[] array1 = list1.toArray();
        System.out.println("Массив, полученный из списка1 = " + Arrays.toString(array1));

        List<Integer> list3 = new ArrayList<>(Arrays.asList(7, 8, 9));

        if (list1.addAll(list3)) {
            System.out.println("Добавление всех элементов списка3 в список1 прошло успешно");
        } else {
            System.out.println("Не удалось добавть элементы списка3 в список1, список пуст");
        }

        List<Integer> list5 = new ArrayList<>(Arrays.asList(5, 8, 10));

        if (list1.removeAll(list5)) {
            System.out.println("Из списка1 были удалены все элементы, которые есть в списке5");
        } else {
            System.out.println("В списке1 не было элементов из списка5");
        }

        List<Integer> list6 = new ArrayList<>(Arrays.asList(1, 8, 4, 7));

        System.out.println("Список1 до применения retainAll = " + list1);

        if (list1.retainAll(list6)) {
            System.out.println("В списке1 оставлены только элементы, которые есть в списке6");
        } else {
            System.out.println("В списке1 не найдено ни одного элемента из списка6");
        }

        System.out.println("Список1 после применения retainAll = " + list1);

        list1.clear();

        System.out.println("Список1 пуст = " + list1.isEmpty());
    }
}