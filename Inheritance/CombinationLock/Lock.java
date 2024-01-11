package CombinationLock;
public class Lock{
    private boolean locked;

    public Lock(){}
    public void open(){
        locked = false;
    }
    public void close(){
        locked = true;
    }
    public String toString(){
        if(locked == false){
            return("The lock is open");
        }
        else{
            return("The lock is closed");
        }
    }
}
