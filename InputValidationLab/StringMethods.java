import java.util.Scanner;
public class StringMethods {
    public StringMethods(){}
    public void unusualHello(String str){
        System.out.println("Hello "+ str + ", you dummy!");}
    public String stringRipper(String str){
        return str.substring(0, 1) + str.substring(str.length() - 1, str.length());
    }
    public boolean evenFooBar(String s){
        int fooCount = 0;
        int barCount = 0;
        for(int i = 0; i < s.length()-2; i++){
            if(s.substring(i, i + 3).equals("foo")){
                fooCount++;}
            else if(s.substring(i, i + 3).equals("bar")){
                barCount++;}
            else{
            continue;}}
        return(barCount == fooCount);}
    public int sumString(String str){
        int count = 0;
        Scanner scan = new Scanner(str);
        scan.useDelimiter(" ");
        while(scan.hasNext()){
            count++;
            scan.next();
        }
        scan.close();
        return count - 1;
    }
    public String decode(String key, String code){
        code = code.replace(" ", "");
        String res = "";
        int intVal;
        for (int i = 0; i < code.length(); i++){
            intVal = Integer.parseInt(code.substring(i, i + 1));
            res += key.substring(intVal, intVal + 1);
        }
        return res;
    }
}
