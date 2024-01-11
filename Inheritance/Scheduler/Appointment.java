package Scheduler;
public class Appointment extends Date{
    String purpose;
    public Appointment(int m, int d, int y, String p){
        super(m, d, y);
        purpose = p;
    }
    public String getText(){
        return purpose;
    }
    public String toString(){
        return super.toString() + " " + purpose;
    }
}
