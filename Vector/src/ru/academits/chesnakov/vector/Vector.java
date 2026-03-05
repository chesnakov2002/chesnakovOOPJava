package ru.academits.chesnakov.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] vectorArray;

    public Vector(int n) {
        isEmpty(n);
        this.n = n;
        this.vectorArray = new double[n];
    }


    public Vector(Vector vector) {
        this.n = vector.n;
        this.vectorArray = Arrays.copyOf(vector.vectorArray, vector.n);
    }

    public Vector(double[] vectorArray) {
        isEmpty(vectorArray.length);
        this.n = vectorArray.length;
        this.vectorArray = Arrays.copyOf(vectorArray, vectorArray.length);
    }

    public Vector(int n, double[] vectorArray) {
        isEmpty(n);
        this.n = n;
        this.vectorArray = Arrays.copyOf(vectorArray, n);
    }

    private static void isEmpty(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размер вектора меньше или равен нулю");
        }
    }
}
