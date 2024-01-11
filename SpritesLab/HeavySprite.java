public class HeavySprite extends BouncingSprite
{
    public HeavySprite( double velX, double velY, double x, double y, int width, int height, String image)
    {
        super( velX, velY,x,y,width,height,  image);
    }
    
    @Override
    public void step(World world)
    {
        super.step(world);
        super.setVY(super.getVY()-0.1);
}

}
