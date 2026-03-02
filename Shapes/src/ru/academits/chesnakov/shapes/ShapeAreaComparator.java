package ru.academits.chesnakov.shapes;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Shape shape1 = (Shape) o1;
        Shape shape2 = (Shape) o2;
        return Double.compare(shape1.getArea(), shape2.getArea());
    }
}

