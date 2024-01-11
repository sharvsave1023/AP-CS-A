package UsedCars;

public class Vehicle {
    String type;
    int year;
    double price;

    public Vehicle(String type, int year, double price){
        this.type = type;
        this.year = year;
        this.price = price;
    }

    public String getType(){
        return type;
    }
    public int getYear(){
        return year;
    }
    public double getPrice(){
        return price;
    }
    public String getInfo(){
        return "" + year + type;
    }
}
