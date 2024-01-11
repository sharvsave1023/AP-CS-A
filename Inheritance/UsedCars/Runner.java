package UsedCars;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Car car1 = new Car("honda civic", 2004, 16000, 37);
        Car car2 = new Car("honda accord", 2005, 17000, 34);

        Truck truck1 = new Truck("ford f-150", 2004, 11000, 3000);
        Truck truck2 = new Truck("ford f-151", 2004, 12000, 1500);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(truck1);
        vehicles.add(truck2);

        Inventory inventory = new Inventory(vehicles);
        System.out.println();
        inventory.listInventory();
        System.out.println();
    }
}
