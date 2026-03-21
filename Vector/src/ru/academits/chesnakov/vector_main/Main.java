package ru.academits.chesnakov.vector_main;

import ru.academits.chesnakov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {1, 6, 9};
        double[] array2 = {1, 4, 6, 4, 132, 2, 45, 6};
        double[] array3 = {1, 2, 6, 4, 111};
        double[] array4 = {2, 4, 2, 3, 2, 2, 2, 0, 0};
        double[] array5 = {2, 4, 5};
        double[] array6 = {2, 4, 8, 1, 2, 3};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);
        Vector vector3 = new Vector(array3);
        Vector vector4 = new Vector(array4);
        Vector vector5 = new Vector(array5);
        Vector vector6 = new Vector(array6);
        Vector vector9 = new Vector(new double[]{1, 2, 3, 4, 5, 6, 7, 8});
        Vector vector10 = new Vector(new double[]{1, 2, 3, 4});

        vector1.add(vector2);
        System.out.println("Результат прибавления вектора 2 к вектору 1 = " + vector1);

        vector2.subtract(vector3);
        System.out.println("Результат вычитания вектора 3 из вектора 2 = " + vector2);

        vector3.multiplyByScalar(5);
        System.out.println("Результат умножения вектора 3 на скаляр 5 = " + vector3);

        vector4.invert();
        System.out.println("Результат разворота вектора 4 = " + vector4);

        System.out.println("Длина вектора 5 = " + vector5.getLength());

        System.out.println("Получение компоненты вектора 5 с индексом 2 = " + vector5.getComponent(2));

        vector5.setComponent(2, 8);
        System.out.println("Получение компоненты вектора 5 с индексом 2 = " + vector5.getComponent(2));

        System.out.println("Вектор 5 и вектор 6 равны = " + vector5.equals(vector6));

        Vector vector7 = Vector.getSum(vector5, vector6);
        System.out.println("Вектор полученный в результате сложения вектора 5 и вектора 6 = " + vector7);

        Vector vector8 = Vector.getDifference(vector5, vector6);
        System.out.println("Вектор полученный в результате вычитания вектора 6 из вектора 5 = " + vector8);

        System.out.println("Результат скалярного умножения вектора 9 на вектор 10 = " + Vector.getDotProduct(vector9, vector10));

        System.out.println("Размер вектора 6 = " + vector6.getSize());
    }
}