import java.util.ArrayList;
import java.util.List;

public class SieveProgram{
    public static void main(String[] args){
        List<Integer> oneToThousand = new ArrayList<Integer>();
        for(int i = 1; i <= 1000; i++){
            if(isPrime(i) && i != 1){
                oneToThousand.add(i);
            }
        }
        System.out.println(oneToThousand);
    }

    public static boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        else{
            for(int i = 2; i <= num/2; i++){
                if(num % i == 0){
                    return false;
                }
            }
        }

        return true;

    }
}