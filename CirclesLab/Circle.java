import java.awt.*;

public class Circle {
    int x;
    int y;
    int radius;
    Color color;
    int dx;
    int dy;


    public Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        dx=0;
        dy=0;
    }
    public Circle(int x, int y, int radius, Color color,int dx,int dy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.dx = dx;
        this.dy = dy;
    }
    public void update(){
        bounce();
        x+=dx;
        y+=dy;
    }


    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);
    }

    public static void main(String[] args) {
        new Circle(1, 1, 1, new Color(255, 0, 0)).draw();
        //new Circle(0, 0, 1, new Color(255, 255, 0)).draw();
    }
    public boolean overlaps(Circle c){
        double distance = Math.sqrt(Math.pow(x - c.x,2)+Math.pow(y - c.y,2));
        if(radius+c.radius>distance){
            return true;
        }
        return false;
    }
    public void bounce(){

            if(x+radius>=600 ||x-radius<=0){
                dx*=-1;
            }
            if(y+radius>=600 || y-radius<=0){
                dy*=-1;
            }

    }
    public boolean isClick(){

        double distance = Math.sqrt(Math.pow(Math.abs(x - StdDraw.mouseX()) ,2)+ Math.pow(Math.abs(y - StdDraw.mouseY()), 2));

        if(distance<=radius){

            return true;
        }
        return false;
    }



}
