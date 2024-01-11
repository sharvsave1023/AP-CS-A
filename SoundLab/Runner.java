public class Runner {
    public static void main(String[] args){
        /* double[] clip = {0.5, 1, 0,1};
        Sound.show(clip);
        Sound.play(clip);*/
        double[]clip= Sound.pureTone(7000.0, 5.0);
        Sound.show(clip);
        Sound.play(clip);
        System.out.println(Sound.toNumSamples(1.0));
    }
}