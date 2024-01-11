public class SoundClip {
    double[] clip;
    public SoundClip(){
        clip = null;
    }
    public SoundClip(double [] num){
        clip = num;
    }
    public void adjustVolume(double factor){
        for(int i = 0; i < clip.length; i++){
            clip[i] = factor * clip[i];
        }
    }
    public void mix(double clip1[], double clip2[]){
        int x = clip1.length;
        int y = Math.abs(clip1.length - clip2.length);
        int z = 0;
        int a = 3;
        if(clip1.length > clip2.length){
            x = clip2.length;
        }
        else{
            x = clip1.length;
            a = 2;
        }
        clip = new double[x + y];
        for(int i = 0; i < x; i++){
           clip[i] = clip1[i] + clip2[i];
           z++;
        }
        for (int j = 0; j < y; j++){
            if(a == 1)
                clip[j + z] = clip1[j + z];
            else if (a == 2)
                clip[j + z] = clip2[j + z];
        }
    }
    public void append(double[] other){
        int len = clip.length + other.length;
        double res[] = new double[len];
        for(int i = 0; i < clip.length; i++){
            res[i] = clip[i];
        }
        for(int i = 0; i < other.length; i++){
            res[i + clip.length] = other[i];
        }
        clip = res;
    }
    public void fadeIn(double seconds){
        double val = Sound.toNumSamples(seconds);
        for(int i = 0; i < val; i++){
            clip[i] *= i / val;
        }

    }
    public void fadeOut(double seconds){
        double val = (double) clip.length - Sound.toNumSamples(seconds);
        double val1 = Sound.toNumSamples(seconds);
        for (int i = (int) val; i < clip.length; i++){
            clip[i] *= (clip.length - i) / val1;
        }
    }
    public void speedUp(double factor){
        int val = (int) ((1.0/factor) * clip.length);
        double[] result = new double [val];
        for (int i = 0; i < result.length; i++){
            result[i] = clip[i];
        }
        clip = result;
    }
    public void reverse(){
        int val = clip.length - 1;
        int val1 = 0;
        double [] result = new double[clip.length];
        for (int i = val; i >= 0; i--)
        {
            result[val1] = clip[i];
            val1++;
        }
        clip = result;
    }
}
