public class Team {
    private Player[] players;
    public Team(){
        players = new Player[12];
    }
    public Team(int numPlayers){
        players = new Player[numPlayers];
    }
    public void printTeamStats(){
        for(int i = 0; i <= players.length-1; i++){
            System.out.println(players[i].getName() + "\t #" + players[i].getNum() + "\t average >>> ." +
            (int)(((double)players[i].getHits() / players[i].getAtBats()) * 1000.0) + " ");
        }
    }
    public Player[] getTeam(){
        return players;
    }
    public Player getPlayer(int num){
        return players[num];
    }
    public int getNumPlayers(){
        return players.length;
    }
    public void addPlayer(Player p, int num){
        players[num] = p;
    }
}
