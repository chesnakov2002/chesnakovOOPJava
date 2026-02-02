package ru.academits.chesnakov.rangeMain;

import ru.academits.chesnakov.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(1.1, 3.3);
        Range range2 = new Range(1, 6.5);

        range1.setFrom(1);
        range1.setTo(8);

        System.out.println(range1.getFrom());
        System.out.println(range1.getTo());

        System.out.println(range1.getRangeLength());

        System.out.println(range1.isInside(1));
        System.out.println(range2.isInside(5));

        Range range3 = range1.getIntersection(range2);

        System.out.println(range3.getFrom());
        System.out.println(range3.getTo());

        Range range4 = new Range(11, 33);

        Range[] rangesArray1 = range1.getUnion(range4);
        System.out.println(Arrays.toString(rangesArray1));

        Range range5 = new Range(11, 22);

        Range[] rangesArray2 = range4.getDifference(range5);
        System.out.println(Arrays.toString(rangesArray2));
    }
}
