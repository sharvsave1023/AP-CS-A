import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture{

    /** The 2D array of pixels that comprise this picture */
	private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File("./images/"+picture);
        BufferedImage image;
        if (!file.exists()) throw new RuntimeException("No picture at the location "+file.getPath()+"!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal integer
                 * The below extracts the individual values using bit-shifting and bit-wise ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb>>16)&0xff, (rgb>>8)&0xff, rgb&0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     * @param color The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param color The {@link Color} of the Picture
     * @param width The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length==0 || pixels[0].length==0) throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i<pixels.length; i++) if (pixels[i].length!=width)
            throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels["+i+"].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        if (pixel==null) throw new NullPointerException("Pixel is null"); //guard is required because pixel's value isn't used in this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

	/**
	 * Save the image on disk as a JPEG
	 * Call programmatically on a Picture object, it will prompt you to choose a save location
	 * In the save dialogue window, specify the file AND extension (e.g. "lilies.jpg")
	 * Extension must be .jpg as ImageIO is expecting to write a jpeg
	 */
	public void save()
	{
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    }
		catch(Exception e) {
	        e.printStackTrace();
	    }

		BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

		for (int r = 0; r < this.pixels.length; r++)
			for (int c = 0; c < this.pixels[0].length; c++)
				image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

		//user's Desktop will be default directory location
		JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

		chooser.setDialogTitle("Select picture save location / file name");

		File file = null;

		int choice = chooser.showSaveDialog(null);

		if (choice == JFileChooser.APPROVE_OPTION)
			file = chooser.getSelectedFile();

		//append extension if user didn't read save instructions
		if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg") && !file.getName().endsWith(".JPEG"))
			file = new File(file.getAbsolutePath() + ".jpg");

		try {
			ImageIO.write(image, "jpg", file);
			System.out.println("File created at " + file.getAbsolutePath());
		}
		catch (IOException e) {
			System.out.println("Can't write to location: " + file.toString());
		}
		catch (NullPointerException|IllegalArgumentException e) {
			System.out.println("Invalid directory choice");
		}
	}

	/** return a copy of the reference to the 2D array of pixels that comprise this picture */
	public Pixel[][] getPixels() {
		return pixels;
	}


    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue()
    {
    	for (int r = 0; r < pixels.length; r++){
		    for (int c = 0; c < pixels[r].length; c++){
			    pixels[r][c].setBlue(0);
            }
        }

    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue()
    {
    	for (int r = 0; r < pixels.length; r++){
		    for (int c = 0; c < pixels[r].length; c++){
			    pixels[r][c].setRed(0);
                pixels[r][c].setGreen(0);
            }
        }
    }

    /** invert a picture's colors */
    public void negate()
    {
    	for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[r].length; c++){
                pixels[r][c].setRed(255 - pixels[r][c].getRed());
                pixels[r][c].setGreen(255 - pixels[r][c].getGreen());
                pixels[r][c].setBlue(255 - pixels[r][c].getBlue());
            }
        }
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold)
    {
    	for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[r].length; c++){
                if(pixels[r][c].getBlue() <= threshold){
                    pixels[r][c].setBlue(255 - pixels[r][c].getBlue());
                }
                if(pixels[r][c].getGreen() <= threshold){
                    pixels[r][c].setGreen(255 - pixels[r][c].getGreen());
                }
                if(pixels[r][c].getRed() <= threshold){
                    pixels[r][c].setRed(255 - pixels[r][c].getRed());
                }
            }
        }
    }

    /** convert an image to grayscale */
    public void grayscale()
    {
        int sum = 0;
        for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[r].length; c++){
                sum += pixels[r][c].getRed();
                sum += pixels[r][c].getBlue();
                sum += pixels[r][c].getGreen();
            }
        }
        sum /= 3;
        for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[r].length; c++){
                pixels[r][c].setColor(sum, sum, sum);
            }
        }
    }

	/** change the tint of the picture by the supplied coefficients */
	public void tint(double red, double blue, double green)
	{
		for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[r].length; c++){
                pixels[r][c].setRed((int)red * pixels[r][c].getRed());
                if(pixels[r][c].getRed() >= 255){
                    pixels[r][c].setRed(255);
                }
                pixels[r][c].setGreen((int)green * pixels[r][c].getGreen());
                if(pixels[r][c].getGreen() >= 255){
                    pixels[r][c].setGreen(255);
                }
                pixels[r][c].setBlue((int)blue * pixels[r][c].getBlue());
                if(pixels[r][c].getBlue() >= 255){
                    pixels[r][c].setBlue(255);
                }
            }
        }
	}

	/** reduces the number of colors in an image to create a "graphic poster" effect */
	public void posterize(int span)
	{
		for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                pixels[r][c].setBlue(pixels[r][c].getBlue() / span * span);
                pixels[r][c].setGreen(pixels[r][c].getGreen() / span * span);
                pixels[r][c].setRed(pixels[r][c].getRed() / span * span);
            }
        }
	}

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical()
    {
		Pixel leftPixel  = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int r = 0; r < pixels.length; r++)
		{
			for (int c = 0; c < width / 2; c++)
			{
				leftPixel  = pixels[r][c];
				rightPixel = pixels[r][(width - 1) - c];

				rightPixel.setColor(leftPixel.getColor());
			}
		}
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft()
    {
    	Pixel leftPixel  = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int r = 0; r < pixels.length; r++)
		{
			for (int c = 0; c < width / 2; c++)
			{
				leftPixel  = pixels[r][c];
				rightPixel = pixels[r][(width - 1) - c];

				leftPixel.setColor(rightPixel.getColor());
			}
		}
    }

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal()
    {
        Pixel topPixel = null, bottomPixel = null;
        for (int r = 0; r < pixels.length / 2; r++){
            for (int c = 0; c < pixels[0].length; c++){
                topPixel = pixels[r][c];
                bottomPixel = pixels[(pixels.length - 1) - r][c];
                bottomPixel.setColor(topPixel.getColor());
            }
          }
    }

    /** flip an image upside down about its bottom edge */
    public void verticalFlip()
    {
    	Pixel topPixel  = null;
        Pixel bottomPixel = null;
        Pixel pix = new Pixel(0,0,0);

        int height = pixels.length;

        for (int r = 0; r < height / 2; r++){
            for (int c = 0; c < pixels[0].length; c++){
                topPixel = pixels[r][c];
                bottomPixel = pixels[(height - 1) - r][c];
                pix.setColor(topPixel.getColor());
                topPixel.setColor(bottomPixel.getColor());
                bottomPixel.setColor(pix.getColor());
            }
        }
    }

    /** fix roof on greek temple */
    public void fixRoof()
    {
    	mirrorVertical();
    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist)
    {
    	for(int r = 0; r < pixels.length - 1; r++){
            for(int c = 0; c < pixels[0].length - 1; c++){
                double distRight = pixels[r][c].colorDistance(pixels[r][c+1].getColor());
                double distBottom = pixels[r][c].colorDistance(pixels[r+1][c].getColor());
                if(distRight > dist || distBottom > dist){
                    pixels[r][c].setColor(0,0,0);
                }
                else{
                    pixels[r][c].setColor(255,255,255);
                }
            }
        }
    }


	/** copy another picture's pixels into this picture, if a color is within dist of param Color */
	public void chromakey(Picture other, Color color, int dist)
	{
		for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                double fromColor = pixels[r][c].colorDistance(color);
                Pixel otherPixel = other.getPixel(c,r);
                if(fromColor < dist){
                    pixels[r][c].setColor(otherPixel.getColor());
                }
            }
        }
	}

	/** steganography encode (hide the message in msg in this picture) */
	public void encode(Picture msg)
	{
		for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                int redValue = pixels[r][c].getRed();
                if(redValue % 2 != 0){
                    pixels[r][c].setRed(redValue - 1);
                }
                redValue = pixels[r][c].getRed();
                Pixel code = msg.getPixel(c,r);
                double blackness = code.colorDistance(Color.BLACK);
                if(blackness < 50){
                    pixels[r][c].setRed(redValue + 1);
                }
            }
        }
	}

	/** steganography decode (return a new Picture containing the message hidden in this picture) */
	public Picture decode()
	{
		Picture message = new Picture(getHeight(), getWidth());
        for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                int redValue = pixels[r][c].getRed();
                Pixel code = message.getPixel(c,r);
                if(redValue % 2 == 0){
                    code.setColor(255,255,255);
                }else{
                    code.setColor(0,0,0);
                }
            }
        }
        return message;
	}

	/** perform a blur using the colors of pixels within radius of current pixel */
	public Picture blur(int radius)
	{
		Picture blur = new Picture(getHeight(), getWidth());
        for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                int redTotal = pixels[r][c].getRed();
                int greenTotal = pixels[r][c].getGreen();
                int blueTotal = pixels[r][c].getBlue();
                int numPixels = 1;
                for(int i = r + 1; i <= r + radius; i++)
                {
                    if(i >= pixels.length){
                        break;
                    }
                    redTotal += pixels[i][c].getRed();
                    greenTotal += pixels[i][c].getGreen();
                    blueTotal += pixels[i][c].getBlue();
                    numPixels++;
                }
                for(int i = r - 1; i >= r - radius; i--)
                {
                    if(i < 0){
                        break;
                    }
                    redTotal += pixels[i][c].getRed();
                    greenTotal += pixels[i][c].getGreen();
                    blueTotal += pixels[i][c].getBlue();
                    numPixels++;
                }
                for(int i = c + 1; i <= c + radius; i++)
                {
                    if(i >= pixels[0].length){
                        break;
                    }
                    redTotal += pixels[r][i].getRed();
                    greenTotal += pixels[r][i].getGreen();
                    blueTotal += pixels[r][i].getBlue();
                    numPixels++;
                }
                for(int i = c - 1; i >= c - radius; i--)
                {
                    if(i < 0){
                        break;
                    }
                    redTotal += pixels[r][i].getRed();
                    greenTotal += pixels[r][i].getGreen();
                    blueTotal += pixels[r][i].getBlue();
                    numPixels++;
                }
                int redAvg = redTotal / numPixels;
                int greenAvg = greenTotal / numPixels;
                int blueAvg = blueTotal / numPixels;
                blur.getPixel(c,r).setColor(redAvg, greenAvg, blueAvg);
            }
	}
    return blur;
}
    /** perform a simple blur using the colors of neighboring pixels */
	public Picture simpleBlur()
	{
		return blur(1);
	}

	/**
	 * Simulate looking at an image through a pane of glass
	 * @param dist the "radius" of the neighboring pixels to use
	 * @return a new Picture with the glass filter applied
	 */
    private int randomVariation(int distance)
    {
        int base = (int) (Math.random() * (distance * 2));
        int num = base - distance;
        return num;
    }
	public Picture glassFilter(int dist)
	{
		Picture glass = new Picture(getHeight(), getWidth());
        for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                int newX = 0;
                int newY = 0;
                while(true){
                    int randomX = randomVariation(dist);
                    if(r + randomX >= 0 && r + randomX < pixels.length){
                        newX = r + randomX;
                        break;
                    }
                }
                while(true){
                    int randomY = randomVariation(dist);
                    if(c + randomY >= 0 && c + randomY < pixels[0].length){
                        newY = c + randomY;
                        break;
                    }
                }
                Pixel newPixel = pixels[newX][newY];
                glass.getPixel(c,r).setColor(newPixel.getColor());
            }
        }
        return glass;
	}
}
