package ru.academits.chesnakov.shape_main;

import ru.academits.chesnakov.circle.Circle;
import ru.academits.chesnakov.rectangle.Rectangle;
import ru.academits.chesnakov.shape.Shape;
import ru.academits.chesnakov.square.Square;
import ru.academits.chesnakov.triangle.Triangle;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Triangle(1, 4, 3, 8, 6, 2);

        System.out.println("Высота треугольника = " + shape1.getHeight());
        System.out.println("Ширина треугольника = " + shape1.getWidth());
        System.out.println("Площадь треугольника = " + shape1.getArea());
        System.out.println("Периметр треугольника = " + shape1.getPerimeter());

        Shape shape2 = new Square(2);

        System.out.println("Высота квадрата = " + shape2.getHeight());
        System.out.println("Ширина квадрата = " + shape2.getWidth());
        System.out.println("Площадь квадрата = " + shape2.getArea());
        System.out.println("Периметр квадрата = " + shape2.getPerimeter());

        Shape shape3 = new Rectangle(2, 5);

        System.out.println("Высота прямоугольника = " + shape3.getHeight());
        System.out.println("Ширина прямоугольника = " + shape3.getWidth());
        System.out.println("Площадь прямоугольника = " + shape3.getArea());
        System.out.println("Периметр прямоугольника = " + shape3.getPerimeter());

        Shape shape4 = new Circle(5);

        System.out.println("Высота окружности = " + shape4.getHeight());
        System.out.println("Ширина окружности = " + shape4.getWidth());
        System.out.println("Площадь окружности = " + shape4.getArea());
        System.out.println("Периметр окружности = " + shape4.getPerimeter());
    }
}
