/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Patrik Bogdan
 */
public class Task {

    protected ArrayList<Polygon> polygons;
    protected Point recordedPoint;

    public Task(ArrayList<Polygon> polygons, Point recordedPoint) {
        this.polygons = polygons;
        this.recordedPoint = recordedPoint;
    }

    public void read(String filename) throws FileNotFoundException, IOException, NoReadableInputException {
        FileReader fileReader = new FileReader(filename);
        Scanner sc = new Scanner(new BufferedReader(fileReader));

        int numberOfLines = sc.nextInt();

        if (numberOfLines == 0) {
            throw new NoReadableInputException();
        }

        while (sc.hasNext()) {
            Polygon p;
            switch (sc.next()) {
                case "CIRCLE":
                    p = new Circle(new Point(Double.parseDouble(sc.next()),
                            Double.parseDouble(sc.next())),
                            Double.parseDouble(sc.next()));
                    polygons.add(p);
                    break;
                case "TRIANGLE":
                    p = new Triangle(new Point(Double.parseDouble(sc.next()),
                            Double.parseDouble(sc.next())),
                            Double.parseDouble(sc.next()));
                    polygons.add(p);
                    break;
                case "SQUARE":
                    p = new Square(new Point(Double.parseDouble(sc.next()),
                            Double.parseDouble(sc.next())),
                            Double.parseDouble(sc.next()));
                    polygons.add(p);
                    break;
                case "HEXAGON":
                    p = new Hexagon(new Point(Double.parseDouble(sc.next()),
                            Double.parseDouble(sc.next())),
                            Double.parseDouble(sc.next()));
                    polygons.add(p);
                    break;
            }
        }
        fileReader.close();
    }

    public int numberOfContainingPolygons(Point recordedPoint) {
        int polygonCounter = 0;

        for (Polygon currPolygon : polygons) {
            if (currPolygon.containsGivenPoint(recordedPoint)) {
                polygonCounter++;
            }
        }
        return polygonCounter;
    }

    public void writeResult() {
        if (numberOfContainingPolygons(recordedPoint) == 0) {
            System.out.println("There are no polygons that contain the point "
                    + recordedPoint + ".");
        } else {
            System.out.println("There are " + numberOfContainingPolygons(recordedPoint)
                    + " polygons that contain the point " + recordedPoint + ".");
        }
    }
}
