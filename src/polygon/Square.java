/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

import java.util.ArrayList;

/**
 *
 * @author Patrik Bogdan
 */
public class Square extends Polygon {

    /**
     * the square's sides' length
     */
    protected double sideLength;

    public Square(Point center, double sideLength) {
        super("SQUARE", center);
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Polygon: " + polygonId + ", center: (" + center.getX() + ", "
                + center.getY() + "), side length: " + sideLength;
    }

    @Override
    public boolean containsGivenPoint(Point p) {
        ArrayList<Point> edges = calculateVertices();

        double x1 = edges.get(0).getX(), y1 = edges.get(0).getY();
        double x2 = edges.get(3).getX(), y2 = edges.get(3).getY();

        return ((p.getX() >= x1) && (p.getX() <= x2)
                && (p.getY() >= y1) && (p.getY() <= y2));
    }

    @Override
    protected ArrayList<Point> calculateVertices() {
        ArrayList<Point> squareVertices = new ArrayList<>();

        double v1_x = center.getX() - sideLength / 2;
        double v1_y = center.getY() - sideLength / 2;
        Point vertex1 = new Point(v1_x, v1_y);
        squareVertices.add(vertex1);

        double v2_x = center.getX() + sideLength / 2;
        double v2_y = center.getY() - sideLength / 2;
        Point vertex2 = new Point(v2_x, v2_y);
        squareVertices.add(vertex2);

        double v3_x = center.getX() - sideLength / 2;
        double v3_y = center.getY() + sideLength / 2;
        Point vertex3 = new Point(v3_x, v3_y);
        squareVertices.add(vertex3);

        double v4_x = center.getX() + sideLength / 2;
        double v4_y = center.getY() + sideLength / 2;
        Point vertex4 = new Point(v4_x, v4_y);
        squareVertices.add(vertex4);

        return squareVertices;
    }
}
