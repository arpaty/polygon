/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Patrik Bogdan
 */
public class PolygonMain {

    public static void main(String[] Args) throws IOException {

        Point recordedPoint = new Point(5, 3);

        ArrayList<Polygon> polygons = new ArrayList<>();

        Task t = new Task(polygons, recordedPoint);

        try {
            t.read("input1.txt");
            t.writeResult();
        } catch (FileNotFoundException ex) {
            System.out.println("The file does not exist.");
        } catch (NoReadableInputException ex) {
            System.out.println("There is no readable input in the file.");
        }
    }
}
