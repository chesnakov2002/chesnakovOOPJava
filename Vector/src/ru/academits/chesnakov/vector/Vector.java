package ru.academits.chesnakov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int vectorSize) {
        validateSize(vectorSize);
        components = new double[vectorSize];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        validateSize(components.length);
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int vectorSize, double[] components) {
        validateSize(vectorSize);
        this.components = Arrays.copyOf(components, vectorSize);
    }

    private static void validateSize(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Размер вектора меньше или равен нулю. " +
                    "Переданный размер = " + vectorSize);
        }
    }

    public int getSize() {
        return components.length;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);

        newVector.add(vector2);

        return newVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);

        newVector.subtract(vector2);

        return newVector;
    }

    public static double getDotProduct(Vector vector1, Vector vector2) {
        int minSize = Math.min(vector1.components.length, vector2.components.length);

        double result = 0;

        for (int i = 0; i < minSize; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }

    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void invert() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < components.length; i++) {
            stringBuilder.append(components[i]);

            if (i < components.length - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append('}');

        return stringBuilder.toString();
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
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }
}