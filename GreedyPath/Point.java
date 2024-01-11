public class Point
{
	private double  x, y;
	private boolean visited;
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	/** get the Euclidean distance between two points */
	public double getDistance(Point other)
	{
		//TODO
		return Math.sqrt(Math.pow(x-other.getX(),2) + Math.pow(y-other.getY(),2));
	}
	
	@Override
	public String toString()
	{
		//TODO
		
		return "X value: " + x + ", Y value: "+ y;
	}
	public void visited(){
		visited = true;
	}
	public boolean isVisited() {
		return visited;
	}

	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
}
