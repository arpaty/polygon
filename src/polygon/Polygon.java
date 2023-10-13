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
public abstract class Polygon {

    /**
     * the polygon's identifier
     * the polygon's center's coordinates
     */
    protected String polygonId;
    protected Point center;

    public Polygon(String polygonId, Point center) {
        this.polygonId = polygonId;
        this.center = center;
    }

    @Override
    public abstract String toString();

    /**
     * @param p the recorded point on the plane which you want to check
     * @return true if point lies either inside or on the polygon, false if
     * point lies outside the polygon
     */
    public abstract boolean containsGivenPoint(Point p);

    /**
     * @return the actual polygon's edges calculated in a list
     */
    protected abstract ArrayList<Point> calculateVertices();
}
