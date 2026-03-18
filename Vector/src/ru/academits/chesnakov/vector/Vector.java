package ru.academits.chesnakov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int arrayLength) {
        validateLength(arrayLength);
        components = new double[arrayLength];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        validateLength(components.length);
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int arrayLength, double[] components) {
        validateLength(arrayLength);
        this.components = Arrays.copyOf(components, arrayLength);
    }

    private static void validateLength(int arrayLength) {
        if (arrayLength <= 0) {
            throw new IllegalArgumentException("Размер вектора меньше или равен нулю." +
                    "Размер переданного массива = " + arrayLength);
        }
    }

    public int getSize() {
        return components.length;
    }

    public static Vector getAdd(Vector vector1, Vector vector2) {
        int maxSize = Math.max(vector1.components.length, vector2.components.length);

        double[] newComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            if (i >= vector1.components.length) {
                newComponents[i] = vector2.components[i];
            } else if (i >= vector2.components.length) {
                newComponents[i] = vector1.components[i];
            } else {
                newComponents[i] = vector1.components[i] + vector2.components[i];
            }
        }

        return new Vector(newComponents);
    }
    /* public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }*/

    public static Vector getSubtract(Vector vector1, Vector vector2) {
        int maxSize = Math.max(vector1.components.length, vector2.components.length);

        double[] newComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            if (i >= vector1.components.length) {
                newComponents[i] = -vector2.components[i];
            } else if (i >= vector2.components.length) {
                newComponents[i] = vector1.components[i];
            } else {
                newComponents[i] = vector1.components[i] - vector2.components[i];
            }
        }

        return new Vector(newComponents);
    }

    public static Vector getMultiply(Vector vector1, Vector vector2) {
        int maxSize = Math.max(vector1.components.length, vector2.components.length);

        double[] newComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            if (i >= vector1.components.length || i >= vector2.components.length) {
                newComponents[i] = 0;
            } else {
                newComponents[i] = vector1.components[i] * vector2.components[i];
            }
        }

        return new Vector(newComponents);
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
        for (int i = 0; i < components.length; i++) {
            components[i] *= -1;
        }
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

    public void setComponent(double component, int index) {
        components[index] = component;
    }

    @Override
    public String toString() {
        return '{' + Arrays.toString(components) + '}';
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
        return components.length == vector.components.length && Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + components.length;
        hash = prime * hash + Arrays.hashCode(components);

        return hash;
    }
}