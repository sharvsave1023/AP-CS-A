package UsedCars;
import java.util.ArrayList;
public class Inventory {
    ArrayList<Vehicle> vehicles;

    public Inventory(ArrayList<Vehicle> v){
        vehicles = v;
    }
    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }
    public void listInventory(){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.getInfo());
        }
}
}