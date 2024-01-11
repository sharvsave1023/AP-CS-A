import java.util.Scanner;
import java.io.*;
public class Runner {
    public static void main(String[] args){
        Scanner scan = null;
        File file = new File("/Users/sharvfiles/Documents/VS Code/java/BattingAverage/players.txt");
        try{
            scan = new Scanner(file);
        } catch(IOException e){
            System.out.println("File Not Found. ");
        }
        int p = scan.nextInt();
        Team liberty = new Team(p);

        for(int i = 0; i < p; i++){
            String name = scan.next();
            int num = scan.nextInt();
            int atBats = scan.nextInt();
            int hits = scan.nextInt();
            liberty.getTeam()[i] = new Player(name, num, atBats, hits);
        }
        liberty.printTeamStats();
    }
}
