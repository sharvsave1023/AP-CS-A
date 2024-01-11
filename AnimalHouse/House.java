import java.util.*;

public class House {
    ArrayList<Animal> animals = new ArrayList<>();
    public void printAnimals(){
        for(int i = 0; i < animals.size(); i++){
            System.out.println(animals.get(i).toString());
        }
    }
    public void add(Animal a){
        animals.add(a);
    }
    public void cleanHouse(){
        for(Animal a : animals){
            ArrayList<Toy> toys = a.getToys();
            for(int i = 0; i < toys.size(); i++){
                for(int k = i + 1; k < toys.size(); k++){
                    if(toys.get(i).equals(toys.get(k))){
                        toys.remove(k);
                        k--;
                    }
                }
            }
        }
    }
}
