import java.util.List;

public abstract class Board {
    private int BOARD_SIZE;
    int[] POINT_VALUES;
    
    public Board(int size, int[] POINT_VALUES){
        BOARD_SIZE = size;
        this.POINT_VALUES = POINT_VALUES;
    }
    
    public abstract int size();
    public abstract Card cardAt(int i);
    public abstract int deckSize();
    public abstract boolean anotherPlayIsPossible();
    public abstract boolean isLegal(List<Integer> y);
    public abstract void replaceSelectedCards(List<Integer> y);
    public abstract boolean isEmpty();
    public abstract void newGame();
    
}

