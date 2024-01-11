public class Player{
    private String name;
    private int number;
    private int atBats;
    private int hits;

    public Player(String pName, int pNum){
        name = pName;
        number = pNum;

    }
    public Player(String pName, int pNum, int atB, int pHit){
        name = pName;
        number = pNum;
        atBats = atB;
        hits = pHit;
    }
    public double getBattingAverage(){
        return (double) (this.hits / this.atBats);
    }
    public String getBattingAverageString(){
        double output = getBattingAverage() * 1000;
        return "" + Math.round(output);
    }
    public String getName(){
        return name;
    }
    public int getNum(){
        return number;
    }
    public int getAtBats(){
        return atBats;
    }
    public int getHits(){
        return hits;
    }
}