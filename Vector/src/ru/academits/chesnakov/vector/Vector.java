package ru.academits.chesnakov.vector;

import ru.academits.chesnakov.vector_main.Main;

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

    private static int getSize(Vector vector) {
        return vector.n;
    }

    // TODO: Сделать чтобы выводились только фигурные скобки {}, без массива [].
    @Override
    public String toString() {
        return '{' + Arrays.toString(vectorArray) + '}';
    }

    public void add(Vector vector) {
        if (n < vector.n) {
            vectorArray = Arrays.copyOf(vectorArray, vector.n);
            n = vector.n;
        }

        for (int i = 0; i < vector.n; i++) {
            vectorArray[i] += vector.vectorArray[i];
        }
    }

    public void subtract(Vector vector) {
        if (n < vector.n) {
            vectorArray = Arrays.copyOf(vectorArray, vector.n);
            n = vector.n;
        }

        for (int i = 0; i < vector.n; i++) {
            vectorArray[i] -= vector.vectorArray[i];
        }
    }

    public void multiply(Vector vector) {
        if (n < vector.n) {
            vectorArray = Arrays.copyOf(vectorArray, vector.n);
            n = vector.n;
        }

        for (int i = 0; i < vector.n; i++) {
            vectorArray[i] *= vector.vectorArray[i];
        }
    }

    public void invert() {
        for (int i = 0; i < n; i++) {
            vectorArray[i] *= -1;
        }
    }

    public double getLength() {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += vectorArray[i] * vectorArray[i];
        }

        return Math.abs(Math.sqrt(sum));
    }

    public double getComponent(int index) {

    }
}