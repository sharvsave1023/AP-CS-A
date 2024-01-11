public class Toy {
    private String name;
    public Toy(String n){
        name = n;
    }
    public String toString(){
        return "A " + name;
    }
    public boolean equals(Toy t){
        if(t.name.equals(this.name)){
            return true;
        }
        return false;
    }
}
