public class Cat extends Animal {
    private int numLives;
    public Cat(String n, int b, int num){
        super(n,b);
        numLives = num;

    }
    public Cat(String n, int b){
        this(n,b,9);
    }
    @Override
    public String toString(){
        return super.toString() + " I have " + numLives + " lives.";
    }
}
