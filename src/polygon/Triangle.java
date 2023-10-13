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
public class Triangle extends Polygon {

    /**
     * the triangle's sides' length
     */
    protected double sideLength;

    public Triangle(Point center, double sideLength) {
        super("TRIANGLE", center);
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Polygon: " + polygonId + ", center: (" + center.getX() + ", "
                + center.getY() + "), side length: " + sideLength;
    }

    /**
     * @param p1 the first desired edge of the triangle
     * @param p2 the second desired edge of the triangle
     * @param recordedPoint the point recorded on the plane (the third edge of
     * the triangle)
     * @return the area of the triangle
     */
    protected double areaOfTriangle(Point p1, Point p2, Point recordedPoint) {
        return 0.5 * Math.abs((p1.getX() * (p2.getY() - recordedPoint.getY())
                + p2.getX() * (recordedPoint.getY() - p1.getY())
                + recordedPoint.getX() * (p1.getY() - p2.getY())));
    }

    @Override
    public boolean containsGivenPoint(Point p) {
        ArrayList<Point> edges = calculateVertices();

        double areaOfThisTriangle = sideLength
                * (Math.sqrt(3) / 2 * sideLength) / 2;

        double otherTrianglePart1 = areaOfTriangle(edges.get(0), edges.get(1), p);
        double otherTrianglePart2 = areaOfTriangle(edges.get(0), edges.get(2), p);
        double otherTrianglePart3 = areaOfTriangle(edges.get(1), edges.get(2), p);

        double wholeOtherArea = otherTrianglePart1 + otherTrianglePart2
                + otherTrianglePart3;

        return areaOfThisTriangle >= wholeOtherArea;
    }

    @Override
    protected ArrayList<Point> calculateVertices() {
        ArrayList<Point> triangleVertices = new ArrayList<>();

        Point a = new Point(center.getX(), center.getY()
                + Math.sqrt(3) * sideLength / 3);
        triangleVertices.add(a);
        Point b = new Point(center.getX() - sideLength / 2,
                center.getY() - Math.sqrt(3) * sideLength / 6);
        triangleVertices.add(b);
        Point c = new Point(center.getX() + sideLength / 2,
                center.getY() - Math.sqrt(3) * sideLength / 6);
        triangleVertices.add(c);

        return triangleVertices;
    }
}
