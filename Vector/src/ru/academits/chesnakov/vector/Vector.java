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

    public static int getSize(Vector vector) {
        return vector.n;
    }

    public static Vector addVectors(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.n, vector2.n);

        double[] newVectorArray = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            if (i >= vector1.n) {
                newVectorArray[i] = vector2.vectorArray[i];
            } else if (i >= vector2.n) {
                newVectorArray[i] = vector1.vectorArray[i];
            } else {
                newVectorArray[i] = vector1.vectorArray[i] + vector2.vectorArray[i];
            }
        }

        return new Vector(newVectorArray);
    }

    public static Vector subtractVectors(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.n, vector2.n);

        double[] newVectorArray = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            if (i >= vector1.n) {
                newVectorArray[i] = -vector2.vectorArray[i];
            } else if (i >= vector2.n) {
                newVectorArray[i] = vector1.vectorArray[i];
            } else {
                newVectorArray[i] = vector1.vectorArray[i] - vector2.vectorArray[i];
            }
        }

        return new Vector(newVectorArray);
    }

    public static Vector multiplyVectors(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.n, vector2.n);

        double[] newVectorArray = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            if (i >= vector1.n || i >= vector2.n) {
                newVectorArray[i] = 0;
            } else {
                newVectorArray[i] = vector1.vectorArray[i] * vector2.vectorArray[i];
            }
        }

        return new Vector(newVectorArray);
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

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < n; i++) {
            vectorArray[i] *= scalar;
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
        return vectorArray[index];
    }

    public void setComponent(double component, int index) {
        vectorArray[index] = component;
    }

    @Override
    public String toString() {
        return '{' + Arrays.toString(vectorArray) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;
        return n == vector.n && Arrays.equals(vectorArray, vector.vectorArray);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + n;
        hash = prime * hash + Arrays.hashCode(vectorArray);

        return hash;
    }
}