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
public class Circle extends Polygon {

    /**
     * the circle's radius
     */
    protected double radius;

    public Circle(Point center, double radius) {
        super("CIRCLE", center);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Polygon: " + polygonId + ", center: (" + center.getX() + ", "
                + center.getY() + "), radius: " + radius;
    }

    @Override
    public boolean containsGivenPoint(Point p) {

        double first_half = Math.pow((center.getX() - p.getX()), 2);
        double second_half = Math.pow((center.getY() - p.getY()), 2);
        double sum = first_half + second_half;

        if (sum == Math.pow(this.radius, 2)) {
            return true;
        }

        return sum < Math.pow(this.radius, 2);
    }

    @Override
    protected ArrayList<Point> calculateVertices() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
