import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations {
    private ArrayList<Circle> circles; //the circles to animate
    private int size;    //canvas width and height (will be square)
    private Random rng;     //use to make random numbers

    /**
     * create a drawing pane of a particular size
     */
    public CircleAnimations(int s) {
        circles = new ArrayList<>();
        size = s;
        rng = new Random();

        //don't mess with this
        StdDraw.setCanvasSize(size, size); //set up drawing canvas
        StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
        StdDraw.setYscale(0, size);
    }

    public void drawCircle() {
        for (int i = 0; i < circles.size(); i++) {
            circles.get(i).draw();
        }
    }

    public void addCircle() {
        Random rng = new Random();
        for (int i = 0; i < 3; i++) {

            circles.add(new Circle(rng.nextInt(500) + 1, rng.nextInt(500) + 1, rng.nextInt(100) + 1, new Color(rng.nextInt(255) + 1, rng.nextInt(255) + 1, rng.nextInt(255) + 1), rng.nextInt(5) + 1, rng.nextInt(5) + 1));
        }
    }

    public void noOverlapping() {
        Random rng = new Random();
        circles.add(new Circle(rng.nextInt(600) + 1, rng.nextInt(600) + 1, rng.nextInt(75) + 1, new Color(rng.nextInt(255) + 1, rng.nextInt(255) + 1, rng.nextInt(255) + 1)));
        for (int i = 0; i < 2000; i++) {
            Circle temp = new Circle(rng.nextInt(600) + 1, rng.nextInt(600) + 1, rng.nextInt(75) + 1, new Color(rng.nextInt(255) + 1, rng.nextInt(255) + 1, rng.nextInt(255) + 1));
            boolean overlap = false;
            for (int j = 0; j < circles.size(); j++) {
                if (circles.get(j).overlaps(temp)) {
                    overlap = true;
                    break;
                }
            }
            if (!overlap) {
                circles.add(temp);
            } else {
                i--;
            }
        }
    }

    public void movingCircles() {
        while (true) {
            removeClicked();

            StdDraw.clear();
            for (int i = 0; i < circles.size(); i++) {
                circles.get(i).update();
            }
            drawCircle();
            StdDraw.show(10);
        }
    }

    public void removeClicked() {
        if (StdDraw.isMousePressed()) {
            for (int i = 0; i < circles.size(); i++) {
                //double distance = Math.sqrt(Math.pow(circles.get(i).x - StdDraw.mouseX(), 2) + Math.pow(circles.get(i).y - StdDraw.mouseY(), 2));
                /*if (distance <= circles.get(i).radius && StdDraw.mousePressed()) {
                    circles.remove(i);
                    i--;
                }*/
                if (circles.get(i).isClick()) {
                    circles.remove(i);
                    i--;
                }
            }
        }


    }

}