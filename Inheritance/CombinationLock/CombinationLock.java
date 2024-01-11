package CombinationLock;
import java.util.Scanner;

public class CombinationLock extends Lock{
   private String combination;
   public CombinationLock(){
       super();
   }
   public CombinationLock(String combo){
       combination = combo;
   }

    public void open(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Combo");
        String combo = scan.nextLine();
        if(combo.equals(combination)){
            super.open();
        }
        else{
            super.close();
        }
    }

   public String toString(){
       return super.toString() + "\n" + "Combination: " + combination + "\n";
   }

   public void setCombination(String c){
       combination = c;
   }

   public String getCombination(){
       return combination;
   }
}