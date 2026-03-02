package ru.academits.chesnakov.shapes_main;

import ru.academits.chesnakov.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new ShapeAreaComparator());

        return shapes[shapes.length - 1];
    }

    public static Shape getSecondMaxPerimeterShape(Shape[] shapes) {
        if (shapes.length < 2) {
            throw new IllegalArgumentException("Переданный массив содержит меньше двух объектов");
        }

        Arrays.sort(shapes, new ShapePerimeterComparator());

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape shape1 = new Triangle(1, 4, 3, 8, 6, 2);

        System.out.println(shape1);
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

        Circle circle = new Circle(7);
        System.out.println("Радиус окружности до изменения = " + circle.getRadius());
        circle.setRadius(10);
        System.out.println("Радиус окружности после изменения = " + circle.getRadius());

        System.out.println("Высота окружности = " + circle.getHeight());
        System.out.println("Ширина окружности = " + circle.getWidth());
        System.out.println("Площадь окружности = " + circle.getArea());
        System.out.println("Периметр окружности = " + circle.getPerimeter());

        Shape shape4 = new Rectangle(5, 7);
        Shape shape5 = new Square(5);

        Shape[] shapes = {shape1, shape2, shape3, circle, shape4, shape5};

        Shape maxAreaShape = getMaxAreaShape(shapes);

        System.out.println("Высота большей по площади фигуры = " + maxAreaShape.getHeight());
        System.out.println("Ширина большей по площади фигуры = " + maxAreaShape.getWidth());
        System.out.println("Площадь большей по площади фигуры = " + maxAreaShape.getArea());
        System.out.println("Периметр большей по площади фигуры = " + maxAreaShape.getPerimeter());
        System.out.println("Тип объекта большей по площади фигуры = " + maxAreaShape.getClass());

        Shape secondMaxPerimeterShape = getSecondMaxPerimeterShape(shapes);

        System.out.println("Высота второй по величине периметра фигуры = " + secondMaxPerimeterShape.getHeight());
        System.out.println("Ширина второй по величине периметра фигуры = " + secondMaxPerimeterShape.getWidth());
        System.out.println("Площадь второй по величине периметра фигуры = " + secondMaxPerimeterShape.getArea());
        System.out.println("Периметр второй по величине периметра фигуры = " + secondMaxPerimeterShape.getPerimeter());
        System.out.println("Тип объекта большей по площади фигуры = " + secondMaxPerimeterShape.getClass());
    }
}
