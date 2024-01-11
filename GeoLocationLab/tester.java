import java.util.*;
public class tester {
    //1 and 2
    public static void main(String[] args) {
        //3
        System.out.println("Hello world, again");
        //4
        //this is a comment!
        //5
        int numApples = 1;
        //6
        final int PRICE_OF_APPLES = 90;
        //7
        System.out.println("The total for " + numApples + " apples: " + (numApples * PRICE_OF_APPLES) + " cents");
        //8
        if (numApples * PRICE_OF_APPLES >= 2000) {
            System.out.println("Thank you valued customer!");
        }
        //9
        for (int n = 10; n > 0; n--) {
            System.out.println(n);
        }
        //10
        for (int i = 150; i < 301; i += 3) {
            System.out.println(i);
        }
        //11
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sum += i;
        }
        System.out.println(sum);
        //12
        //riddle answer-- "silence" disappears the moment you say its name
        //13
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Double: ");
        //14
        double num = console.nextDouble();
        //15
        System.out.println("Square root of number: " + Math.sqrt(num));
        //16
        System.out.println("num ^ 3 = " + Math.pow(num, 3));
        System.out.println("Enter two integers: ");
        //17
        int num1 = console.nextInt(), num2 = console.nextInt();
        if (num1 > num2) {
            if (num1 - num2 <= 10) {
                System.out.println("is within 10");
            } else if (num1 - num2 > 10) {
                System.out.println("is not within 10");
            }
        }
        if (num2 > num1) {
            if (num2 - num1 <= 10) {
                System.out.println("is within 10");
            } else if (num2 - num1 > 10) {
                System.out.println("is not within 10");
            }
        }
        //18
        int input = 1;
        int total = 0;
        int numInt = 0;
        System.out.println("Enter integers. Input 0 to quit");
        while (input != 0) {
            input = console.nextInt();
            numInt += 1;
            if (input > 0) {
                total = total + input;
            } else if (input == 0) {
                System.out.println(total / (double) numInt);
                break;
            }
        }
        //19
        double[] areas = new double[20];
        //20
        areas[0] = 4.56;
        //21
        int length = areas.length;
        System.out.println(length);
        //22
        boolean[] boolArr = {true, true, false, false, true};
        System.out.println(boolArr);
        //23
        //riddle answer-- a tombstone
        simpleMethod();
        System.out.println(sum(2, 3));
        System.out.println("enter number to use sumToN");
        int sumInp = console.nextInt();
        System.out.println(sumToN(sumInp));
        System.out.println("enter integer to form pyramid");
        int triInp = console.nextInt();
        Triangle(triInp);

        System.out.println("enter string to use altCaps method");
        String altInp = console.nextLine();
        System.out.println(altCaps(altInp));
        console.close();
    }
    public static void simpleMethod(){
        System.out.println("This is a method!");
    }
    public static int sum(int a, int b){
        return a + b;
    }
    public static int sumToN(int n){
        int three = 0;
        int five = 0;
        for(int i = 0; i <= n; i++){
            if(i % 3 == 0){
                three += i;
            }
            else if(i % 5 == 0){
                five += i;
            }
        }
        return (three + five);
    }
    public static void Triangle(int n){
        int countRow = 1;
        for (int i = n; i > 0; i--) {
            for (int e = 1; e <= countRow; e++) {
                System.out.print(countRow);
            }
            System.out.println();
            countRow++;
        }
    }
    public static String altCaps(String s){
        String result = "";
        for(int i = 1; i < s.length(); i++){
            if(i % 2 == 0){
                result += s.substring(i-1, i).toLowerCase();
            }
            else{
                result += s.substring(i-1, i).toUpperCase();
            }
        }
        return result;
    }
}
class Player{
    String name = "";
    int number = 0;
    public Player(){
        name = "default";
        number = -1;
    }
    public Player(String name, int number){
        this.name = name;
        this.number = number;
    }
    public String playerInfo(){
        return("Player: " + name + ", Number: " + number);
    }
}
class GeoLocation{
    double latitude = 0.0;
    double longitude = 0.0;
    public GeoLocation(double lati, double longi){
        latitude = lati;
        longitude = longi;
    }
    public String toString(){
        return("latitude: " + latitude + ", longitude: " + longitude);
    }
    public Double distanceTo(GeoLocation other){
        double lat1 = Math.toRadians(latitude);
        double long1 = Math.toRadians(longitude);
        double lat2 = Math.toRadians(other.latitude);
        double long2 = Math.toRadians(other.longitude);

        double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2);
        double arcLength = Math.acos(theCos);
        return arcLength * 3963.1676;
    }
}
class Place{
    String name = "";
    String address = "";
    GeoLocation location;
    public Place(String n, String a, double lati, double longi){
        name = n;
        address = a;
        location = new GeoLocation(lati, longi);
    }
    public Place(String n, String a, GeoLocation loc){
        name = n;
        address = a;
        loc = location;

    }
    public double distanceTo(Place other){
        return location.distanceTo(other.location);
    }

    public String toString(){
        return(name + "\n" + address + "\n" + location.toString());
    }
}
class runner{
    public static void main(String[] args){
        Player player1 = new Player();
        Player player2 = new Player("John", 5);
        player1.playerInfo();
        player2.playerInfo();

        GeoLocation location = new GeoLocation(33.12396, -96.798735);
        location.toString();

        Place place = new Place("Frisco ISD Administration Building", "5515 Ohio Dr, Frisco, TX 75035", location);
        Place place2 = new Place("Frisco ISD Admin Building 2.0", "14040 Eldorado Pkwy, Frisco, TX, 75035", 33.1760, 96.7549);

        System.out.println(place.toString());
        System.out.println();
        System.out.println(place2.toString());
        System.out.println();
        System.out.println(place.distanceTo(place2));
    }
}