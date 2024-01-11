import java.util.ArrayList;
import java.util.Collections;

public class GreedyPath extends Path {
    ArrayList<Point> points1;
    Point points[];

    public GreedyPath(String filename) throws Exception {
        super(filename);
        points1 = new ArrayList<>();

        Collections.addAll(points1, getPoints());
        putOrder();
        points = new Point[points1.size()];
        for (int i = 0; i < points1.size(); i++) {
            points[i] = points1.get(i);
        }
    }

    public void putOrder() {
        ArrayList<Point> temp = new ArrayList<>();
        temp.add(points1.remove(0));
        int z = 0;
        while (points1.size() > 1) {
            Point p = temp.get(0);
            int lowestIndex = 0;
            double lowestDistance = temp.get(temp.size() - 1).getDistance(points1.get(0));

            for (int i = 1; i < points1.size(); i++) {
                if (temp.get(temp.size() - 1).getDistance(points1.get(i)) < lowestDistance) {
                    lowestDistance = temp.get(temp.size() - 1).getDistance(points1.get(i));
                    lowestIndex = i;
                }

            }
            temp.add(points1.remove(lowestIndex));
            z++;
        }
        temp.add(points1.remove(0));
        points1 = temp;
    }

    public double getDistance() {
        double total = 0;
        for (int i = 0; i < points.length - 1; i++) {
            total += points[i].getDistance(points[i + 1]);
        }
        return total;
    }

    public String toString() {
        return "";
    }

    public Point getPoint(int index) {
        return points[index];
    }

    public int getNumPoints() {

        return points.length;
    }
}
