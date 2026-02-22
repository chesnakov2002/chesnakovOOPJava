package ru.academits.chesnakov.range_main;

import ru.academits.chesnakov.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(1.1, 3.3);
        Range range2 = new Range(5, 9);

        range1.setFrom(1);
        range1.setTo(8);

        System.out.println("Отрезок 1 имеет from = " + range1.getFrom());
        System.out.println("Отрезок 1 имеет to = " + range1.getTo());
        System.out.println("Длина отрезка 1 = " + range1.getLength());

        System.out.println("Число \"1\" входит в отрезок 1 = " + range1.isInside(1));
        System.out.println("Число \"5\" входит в отрезок 1 = " + range2.isInside(5));

        Range intersection = range1.getIntersection(range2);

        System.out.println("Диапазон пересечения отрезков 1 и 2 имеет from = " + intersection.getFrom());
        System.out.println("Диапазон пересечения отрезков 1 и 2 имеет to = " + intersection.getTo());
        System.out.println("Диапазон пересечения отрезков 1 и 2 имеет длину = " + range1.getLength());

        Range range3 = new Range(1, 13);

        Range[] union = range1.getUnion(range3);
        System.out.println("Массив объединения отрезков 1 и 3 = " + Arrays.toString(union));

        Range range4 = new Range(5, 39);

        Range[] difference = range3.getDifference(range4);
        System.out.println("Массив разности отрезков 3 и 4 = " + Arrays.toString(difference));
    }
}