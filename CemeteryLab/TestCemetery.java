import java.util.ArrayList;
public class TestCemetery
{
    public static void main(String[] args)
    {
        Cemetery grave = new Cemetery("/Users/sharvfiles/Documents/VS Code/java/CemeteryLab/cemetery.txt");
        ArrayList<Tombstone> list = grave.getTombstones();
        double sum = 0;
        int numPep = 0;
        double age = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getAddress().indexOf("Little Carter Lane") >= 0)
            {
                age = (list.get(i).getAge());
                sum += age;
                numPep++;
            }
        }
        sum /= (double)365;
        double avg = Math.round((sum/numPep)*10)/10.0;
        System.out.println("Average age of people that lived on Little Carter Ln: " + avg);
    }
}
