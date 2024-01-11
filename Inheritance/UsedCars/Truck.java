package UsedCars;
public class Truck extends Vehicle{

    private int towing;

    public Truck(String type, int year, double price, int towing){
        super(type, year, price);
        this.towing = towing;
    }

    public boolean canTow(){
        if(towing >= 2000){
            return true;
        }
        return false;
    }
    public String getInfo(){
        return year+" "+ type + ", " + towing + ", " + price;
    }
}
