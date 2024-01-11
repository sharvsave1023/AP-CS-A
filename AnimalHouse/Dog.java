public class Dog extends Animal{
    private boolean goodBoy;
    public Dog(String name, int y, boolean g){
        super(name,y);
        goodBoy = g;
    }
    @Override
    public String toString(){
        if(goodBoy){
            return super.toString() + " I am a good boy.";
        }
        else{
            return super.toString() + " I am not a good boy.";
        }
    }
}
