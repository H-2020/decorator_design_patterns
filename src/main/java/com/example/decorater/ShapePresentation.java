package com.example.decorater;

public class ShapePresentation {

    public static void main(String[] args) {
        //Basic circle
        Shape circle = new Circle();

        //Decorated circle as red color
        Shape redCircle = new RedShapeDecorator(circle);

        //Basic rectangle
        Rectangle rectangle = new Rectangle();

        //Decorated rectangle as red color
        Shape redRectangle = new RedShapeDecorator(rectangle);

        //Decorated redRectangle as double line
        Shape doubleLineRectangle = new DoubleLineShapeDecorator(redRectangle);

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();

        System.out.println("\nRectangle of double line");
        doubleLineRectangle.draw();
    }
}

interface Shape{
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;
    public ShapeDecorator (Shape shape){
        this.decoratedShape = shape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}

class DoubleLineShapeDecorator extends ShapeDecorator {

    public DoubleLineShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setDoubleLine(decoratedShape);
    }

    private void setDoubleLine(Shape decoratedShape){
        System.out.println("Line : Double Line");
    }


}
