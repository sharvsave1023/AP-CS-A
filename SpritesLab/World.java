import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Control;

public class World {
    private List<Sprite> sprites;
    private int width;
    private int height;

    /**
     * construct a world 600x600
     */
    public World() {
        this(600, 600);
    }

    public World(int h, int w) {
        height = h;
        width = w;

        sprites = new ArrayList<>();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.clear(Color.BLACK);
        addSprites(1,1,50,50);
    
    private void addSprites(double x, double y, int width, int height){
       Sprite d = new StationarySprite(20 ,30, width, height, "/Users/sharvfiles/Documents/VS Code/java/SpritesLab/square.png");
       Sprite c = new BouncingSprite(20,30,x,y,width,height,"/Users/sharvfiles/Documents/VS Code/java/SpritesLab/circle.png");
       Sprite h = new HeavySprite(20,30,x,7,width,height, "/Users/sharvfiles/Documents/VS Code/java/SpritesLab/triangle.png");
       Sprite s = new ControllableSprite(3, 3, x, y, 200, , "/Users/sharvfiles/Documents/VS Code/java/SpritesLab/Screen Shot 2022-02-22 at 3.19.32 PM.png");
       sprites.add(d);
       sprites.add(c);
       sprites.add(h);
       sprites.add(s);
    }
    /**
     * add a sprite to the simulation
     */
    public void add(Sprite sprite) {
        this.sprites.add(sprite);
    }

    /**
     * ask all sprites in simulation to update themselves
     */
    public void stepAll() {
        for (int i = 0; i < sprites.size(); i++)
            this.sprites.get(i).step(this);
    }

    /**
     * get the width of the world
     */
    public int getWidth() {
        return width;
    }

    /**
     * get the height of the world
     */
    public int getHeight() {
        return height;
    }

    /**
     * get the number of sprites in the simulation currently
     */
    public int getNumSprites() {
        return sprites.size();
    }

    /**
     * get the sprite at the given index
     */
    public Sprite getSprite(int index) {
        return sprites.get(index);
    }

    /**
     * run the simulation, i.e. the main game loop
     */
    public void run() {
        while (true) {
            this.stepAll();
            this.drawAll();

            StdDraw.show(10); //don't worry about warning if using Eclipse
            StdDraw.clear(Color.BLACK);
        }
    }


    /**
     * draw all sprites in the simulation at their current positions
     */
    public void drawAll() {
        for (Sprite sprite : this.sprites)
            sprite.draw();
    }

    public static void main(String[] args) {
        World world = new World(600, 600);
        world.add(new ControllableSprite(12,12,50,50,256,256,"download.png"));
        world.run();
    }
}
