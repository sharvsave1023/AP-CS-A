import java.util.ArrayList;
import java.util.HashMap;

public class HashMapProbs {
    public static void main(String[] args) {
        HashMap animalSounds = new HashMap();
        animalSounds.put("dog", "woof");
        animalSounds.put("cow", "moo");
        animalSounds.put("bird", "tweet");
        animalSounds.put("lion", "roar");
        //System.out.println(animalSounds);
        System.out.println(charWord(new String[] {"tea", "salt", "soda", "taco "}));
    }
    public static HashMap<String,String> takeBefore(String a, String b){
        HashMap<String,String> y = new HashMap<>();
        for (int i = 0; i < a.length()&&i<b.length(); i++){
            y.put(b.charAt(i)+"",a.charAt(i)+"");
        }
        return y;
    }
    public static HashMap<String, Boolean > multiple ( String s ){
        HashMap<String, Boolean > y = new HashMap<>();
        for(int i = 0 ;i < s.length(); i++){
            if(y.containsKey(s.charAt(i)+"")){
                y.put(s.charAt(i)+"", true);
            }
            else {
                y.put(s.charAt(i)+"", false);
            }
        }
        return y;
    }
    public static HashMap<String, String> charWord(String[] words){
        ArrayList<String> y = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            boolean b = false;
            for(int j  = 0; j < y.size();j++){
                if(y.get(j).charAt(0)==words[i].charAt(0)){
                    y.set(j,y.get(j)+words[i]);
                    b = true;
                    break;
                }

            }
            if (!b){
                y.add(words[i]);
            }

        }
        HashMap<String,String> fin= new HashMap<>();
        for (int i = 0; i < y.size(); i++){
            fin.put(y.get(i).charAt(0)+"",y.get(i));
        }
        return fin;
    }
}
