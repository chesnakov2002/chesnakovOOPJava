package ru.academits.chesnakov.vector_main;

import ru.academits.chesnakov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {1, 6, 9};
        double[] array2 = {1, 4, 6, 4, 132, 2, 45, 6};
        double[] array3 = {1, 2, 6, 4, 111};
        double[] array4 = {2, 4, 2, 3, 2, 2, 2, 0, 0};
        double[] array5 = {2, 4, 8};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);
        Vector vector3 = new Vector(array3);
        Vector vector4 = new Vector(array4);
        Vector vector5 = new Vector(array5);

        vector1.add(vector2);
        System.out.println(vector1);

        vector2.subtract(vector3);
        System.out.println(vector2);

        vector3.multiply(vector4);
        System.out.println(vector3);

        vector4.invert();
        System.out.println(vector4);

        System.out.println(vector5.getLength());
    }
}