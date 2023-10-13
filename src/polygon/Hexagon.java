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
public class Hexagon extends Polygon {

    /**
     * the hexagon's sides' length
     */
    protected double sideLength;

    public Hexagon(Point center, double sideLength) {
        super("HEXAGON", center);
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Polygon: " + polygonId + ", center: (" + center.getX() + ", "
                + center.getY() + "), side length: " + sideLength;
    }

    /**
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @return the distance between the two vectors
     */
    protected double vectorDistance(Point v1, Point v2) {
        return Math.sqrt(Math.pow((v1.getX() - v2.getX()), 2)
                + Math.pow((v1.getY() - v2.getY()), 2));
    }

    /**
     *
     * @param a coordinates of the first edge of the triangle
     * @param b coordinates of the second edge of the triangle
     * @param c coordinates of the third edge of the triangle
     * @return the three sides of the triangle
     */
    protected Double[] triangleSides(Point a, Point b, Point c) {
        double distance1 = vectorDistance(a, b);
        double distance2 = vectorDistance(b, c);
        double distance3 = vectorDistance(a, c);

        Double[] trSides = {distance1, distance2, distance3};

        return trSides;
    }

    /**
     *
     * @param a the first side of the triangle
     * @param b the second side of the triangle
     * @param c the third side of the triangle
     * @return the area of the triangle
     */
    protected double heronsFormula(double a, double b, double c) {
        double semiPerimeter = (a + b + c) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a)
                * (semiPerimeter - b) * (semiPerimeter - c));
    }

    @Override
    public boolean containsGivenPoint(Point p) {
        double areaOfOneTriangle = sideLength * (Math.sqrt(3) / 2 * sideLength) / 2;
        double areaOfBaseHexagon = areaOfOneTriangle * 6;

        ArrayList<Point> edges = calculateVertices();

        Double[] trSides = new Double[3];

        trSides = triangleSides(edges.get(0), edges.get(2), p);
        double firstTriangle = heronsFormula(trSides[0], trSides[1], trSides[2]);

        trSides = triangleSides(edges.get(0), edges.get(1), p);
        double secondTriangle = heronsFormula(trSides[0], trSides[1], trSides[2]);

        trSides = triangleSides(edges.get(1), edges.get(3), p);
        double thirdTriangle = heronsFormula(trSides[0], trSides[1], trSides[2]);

        trSides = triangleSides(edges.get(2), edges.get(4), p);
        double fourthTriangle = heronsFormula(trSides[0], trSides[1], trSides[2]);

        trSides = triangleSides(edges.get(4), edges.get(5), p);
        double fifthTriangle = heronsFormula(trSides[0], trSides[1], trSides[2]);

        trSides = triangleSides(edges.get(5), edges.get(3), p);
        double sixthTriangle = heronsFormula(trSides[0], trSides[1], trSides[2]);

        double otherHexagonArea = firstTriangle + secondTriangle
                + thirdTriangle + fourthTriangle + fifthTriangle + sixthTriangle;

        return areaOfBaseHexagon >= otherHexagonArea;
    }

    @Override
    protected ArrayList<Point> calculateVertices() {
        double triangleHeight = (Math.sqrt(3) / 2) * sideLength;

        ArrayList<Point> hexagonVertices = new ArrayList<>();
        hexagonVertices.add(new Point(center.getX() - sideLength / 2,
                center.getY() + triangleHeight));
        hexagonVertices.add(new Point(center.getX() + sideLength / 2,
                center.getY() + triangleHeight));
        hexagonVertices.add(new Point(center.getX() - sideLength,
                center.getY()));
        hexagonVertices.add(new Point(center.getX() + sideLength,
                center.getY()));
        hexagonVertices.add(new Point(center.getX() - sideLength / 2,
                center.getY() - triangleHeight));
        hexagonVertices.add(new Point(center.getX() + sideLength / 2,
                center.getY() - triangleHeight));

        return hexagonVertices;
    }
}
