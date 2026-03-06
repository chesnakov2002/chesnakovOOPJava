package ru.academits.chesnakov.vector_main;

import ru.academits.chesnakov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {1, 6, 9};
        double[] array2 = {1, 4, 6, 4, 132, 2, 45, 6};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);

        vector1.add(vector2);
        System.out.println(vector1);
    }
}