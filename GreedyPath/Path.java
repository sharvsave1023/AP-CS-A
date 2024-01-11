import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Path {
    private Point[] points;
    private double minX, minY; //min X and Y values, for setting canvas scale
    private double maxX, maxY; //maxes

    /**
     * construct a path from a given file
     */
    public Path(String fileName) throws Exception {
        Scanner in = new Scanner(new File(fileName));
        points = new Point[in.nextInt()];

        minX = in.nextDouble();
        minY = in.nextDouble();
        points[0] = new Point(minX, minY);
        maxY = minY;
        maxX = minX;
        int i = 1;
        while (in.hasNext()) {
            double tempX = in.nextDouble();
            double tempY = in.nextDouble();

            points[i-1] = new Point(tempX, tempY);
            /*if (tempX <= minX && tempY <= minY) {
                minX = tempX;
                minY = tempY;
            } else if (tempX >= maxX && tempY >= maxY) {
                maxX = tempX;
                maxY = tempY;
            }*/
            if (tempX <= minX) {
                minX = tempX;
            } else if (tempX >= maxX) {
                maxX = tempX;
            }
            if (tempY <= minY) {
                minY = tempY;
            } else if (tempY >= maxY) {
                maxY = tempY;
            }
            i++;
        }
    }

    public Path() {

    }

    /**
     * returns the distance traveled going point to point, in order given in file
     */
    public double getDistance() {
        double total = 0;
        for (int i = 0; i < points.length - 1; i++) {
            total += points[i].getDistance(points[i + 1]);
        }
        return total; //replace
    }

    @Override
    public String toString() {
        //TODO

        return "";
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public Point getPoint(int index) {
        return points[index];
    }

    public int getNumPoints() {

        return points.length;
    }

    public Point[] getPoints() {
        return points;
    }
}
