package ru.academits.chesnakov.triangle;

import ru.academits.chesnakov.shape.Shape;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double epsilon = 1e-10;

        if (Math.abs((x1 - x2) * (y1 - y3) - (x1 - x3) * (y1 - y2)) <= epsilon) {
            throw new IllegalArgumentException("Точки лежат на одной прямой");
        }

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        double maxX = Math.max(Math.max(x1, x2), x3);
        double minX = Math.min(Math.min(x1, x2), x3);
        return maxX - minX;
    }

    @Override
    public double getHeight() {
        double maxY = Math.max(Math.max(y1, y2), y3);
        double minY = Math.min(Math.min(y1, y2), y3);
        return maxY - minY;
    }

    @Override
    public double getArea() {
        double sideALength = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double sideBLength = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double sideCLength = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        double halfPerimeter = (sideALength + sideBLength + sideCLength) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - sideALength) *
                (halfPerimeter - sideBLength) * (halfPerimeter - sideCLength));
    }

    @Override
    public double getPerimeter() {
        double sideALength = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double sideBLength = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double sideCLength = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        return sideALength + sideBLength + sideCLength;

    }
}
