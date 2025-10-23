package ua.opnu.model;

import java.awt.*;

public class DrawShape {

    public static DrawShape newInstance(int shapeType) {

        DrawShape shape = null;

        switch (shapeType) {
            case SHAPE_RECTANGLE:
                shape = new Rectangle();
                break;
            case SHAPE_ROUNDED_RECT:
                shape = new RoundedRectangle();
                break;
            case SHAPE_ELLIPSE:
                shape = new Ellipse();
                break;
        }

        return shape;
    }

    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;

    private Point startPoint;
    private Point endPoint;

    public DrawShape() {
        this.startPoint = new Point(0, 0);
        this.endPoint = new Point(0, 0);
    }

    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Shape getShape() {
        return getShape(startPoint, endPoint);
    }

    public Shape getShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        return null;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}