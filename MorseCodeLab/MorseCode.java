import java.util.HashMap;
import java.util.Scanner;

public class MorseCode {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890 ";
    private final String[] morse = {".- ", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".--- ", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..--- ", "...-- ", "....- ", ".....", "-....", "--...", "---..", "----.", "-----", "|"};
    private HashMap<String, String> toText;
    private HashMap<String, String> toCode;

    public MorseCode(){
        toText = new HashMap<>();
        toCode = new HashMap<>();
        for(int i = 0; i < alphabet.length(); i++){
            toText.put(morse[i],alphabet.charAt(i)+"");
        }
        for(int i = 0; i < alphabet.length(); i++){
            toCode.put(alphabet.charAt(i)+"",morse[i]);
        }
    }
    public String encode(String s){
        String encode = "";
        for(int i = 0; i < s.length(); i++){
            encode+=toCode.get(s.charAt(i)+"")+" ";
        }
        return encode.trim();
    }
    public String decode(String s){
        Scanner in = new Scanner(s);
        in.useDelimiter(" ");
        String decode = "";
        while (in.hasNext()){
            decode+=toText.get(in.next());
        }
        return decode.trim();
    }
}


