package UsedCars;
public class Car extends Vehicle {
    private double mpg;
    public Car(String type, int year, double price, double mpg){
        super(type, year, price);
        this.mpg = mpg;
    }
    public boolean greatMPG(){
        if(mpg >= 36){
            return true;
        }
        return false;
    }
    public String getInfo(){
        return year+ " "+ type + ", " + mpg + ", " + price;
    }
}
