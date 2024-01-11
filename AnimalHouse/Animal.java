import java.util.*;

public class Animal {
    private String name;
    private int birthyear;
    private Animal friend = null;
    static int currentYear = 2022;
    public Animal(){ }
    public Animal(String n, int b){
        name = n;
        birthyear = b;
    }
    private ArrayList<Toy> toys = new ArrayList<>();
    public String getName(){return name;}
    public int getBirthyear(){return birthyear;}

    public void addToy(Toy t){
        toys.add(t);
    }
    public ArrayList<Toy> getToys(){ return toys;}
    public void setFriend(Animal f){
        friend = f;
    }
    public int getAge(){
        return currentYear - birthyear;
    }
    public String toString(){
        String a;
        if(friend.equals(null)){
            a = "Hello, I am " + name + ". I am " + getAge() + " years old. I have no friends";
        }
        else{
            a = "Hello, I am " + name + ". I am " + getAge() + " years old. I have a friend named " + friend.getName();
        }
        a = a + ". I have the following toys: " + this.toys.toString();
        return a;
    }

}
