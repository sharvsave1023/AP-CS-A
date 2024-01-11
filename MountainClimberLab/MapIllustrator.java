import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MapIllustrator
{
    /** the 2D array containing the elevations */
    private int[][] grid;
    private int rows;
    private int cols;
    private int max = Integer.MIN_VALUE;//elevation
    private int min = Integer.MAX_VALUE;//elevation

    /** constructor, parses input from the file into grid */
    public MapIllustrator(String fileName)
    {
        try {
            Scanner scan = new Scanner(new File(fileName));
            rows = scan.nextInt();
            cols = scan.nextInt();
            grid = new int[rows][cols];
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    grid[i][j] = scan.nextInt();
                    if (grid[i][j] < min)
                    {
                        min = grid[i][j];
                    }
                    if (grid[i][j] > max)
                    {
                        max = grid[i][j];
                    }
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /** @return the min value in the entire grid */
    public int findMin()
    {
        return min;
    }

    /** @return the max value in the entire grid */
    public int findMax()
    {
        return max; //REPLACE
    }

    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g)
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                int color = 255 * (grid[i][j] - min)/(max-min);
                g.setColor(new Color(color, color, color));
                g.drawRect(j,i,1,1);
            }
        }
    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawPath(Graphics g, int row)
    {
        int elevChange = 0;
        int r = row;
        int c = 0;
        while (c < cols - 1)
        {
            g.drawRect(c, r, 1,1);
            //elevations
            int up = Integer.MAX_VALUE;
            if (r - 1 >= 0)
            {
                up = grid[r-1][c + 1];
            }
            int fwd = grid[r][c + 1];
            int down = Integer.MAX_VALUE;
            if (r + 1 < grid.length)
            {
                down = grid[r + 1][c + 1];
            }
            //elevation change
            int diffUp = Math.abs(grid[r][c] - up);
            int diffFwd = Math.abs(grid[r][c] - fwd);
            int diffDown =  Math.abs(grid[r][c] - down);
            if ( diffUp < diffFwd && diffFwd < diffDown)
            {
                elevChange += diffUp;
                r -= 1;
            }
            if (diffFwd < diffUp && diffFwd < diffDown)
            {
                elevChange += diffFwd;
            }
            if (diffDown < diffUp && diffDown < diffFwd)
            {
                elevChange += diffDown;
                r += 1;
            }
            if ((diffFwd == diffUp  && diffFwd <= diffDown) || (diffFwd == diffDown && diffFwd <= diffUp))
            {
                elevChange += diffFwd;
            }
            if (diffUp == diffDown && diffUp < diffFwd)
            {
                if (Math.random() < .5)
                {
                    elevChange += diffUp;
                    r--;
                }
                else
                {
                    elevChange += diffDown;
                    r++;
                }
            }
            c++;
        }
        
        g.drawRect(c,r, 1,1);
        return elevChange;
    }

    /** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
    public int getIndexOfLowestPath(Graphics g)
    {
        int bestRow = 0;
        int elevLow = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++)
        {
            int elevChange = drawPath(g,i);
            if (elevChange < elevLow)
            {
                elevLow = elevChange;
                bestRow = i;
            }
        }
        return bestRow;
    }

    /** return the number of rows in grid */
    public int getRows()
    {
        return rows;
    }

    /** return the number of columns in grid (assumed rectangular) */
    public int getCols()
    {
        return cols;
    }
}
