import java.util.*;
public class PrintingPrimeFactors  {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String res = "";
        int mod = scan.nextInt();
        int input = mod;
        while(true){
            for(int i = 2; i < mod; i++){
                if(mod % i == 0 && mod != i){
                    res += i + " ";
                    mod /= i;
                    i--;
                }
            }
            res += mod + " ";
            System.out.println("The prime factorization for " + input + " is: " + res);
            res = "";
            mod = scan.nextInt();
            input = mod;
            if(mod == 0){
                scan.close();
                break;
            }
        }
    }

}
