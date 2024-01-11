import java.util.*;
public class PrintingFactors  {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("Enter a number: ");
            int input = scan.nextInt();
            if(input > 0){
                int count = 0;
                for(int i = 1; i <= input; i++){
                    if(input % i == 0){
                        count++;
                    }
                }
                System.out.print("There are " + count + " factors for the number " + input + ": ");
                printFactors(input);
            }
            if(input == 0){
                scan.close();
                break;
            }
        }
    }
    public static void printFactors(int num){
        for(int i=1; i <= num; i++) {
            if(num % i == 0 && i != 1 && i != num)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}
