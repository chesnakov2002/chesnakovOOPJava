package ru.academits.chesnakov.Comparators;

import ru.academits.chesnakov.shapes.Shape;

import java.util.Comparator;

public class ShapePerimeterComparator<T extends Shape> implements Comparator<T> {
    @Override
    public int compare(T shape1, T shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }
}