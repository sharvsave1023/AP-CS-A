import java.util.Arrays;

public class TwoDArrayProb {
    private int[][] nums;

    public TwoDArrayProb(int[][] value){
        nums = value;
    }
    public int sum(){
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            for(int j = 0; j < nums[i].length; ++j) {
              sum += nums[i][j];
            }
          }
        return sum;
    }
    public boolean isSquare(){
        boolean val = false;
        for(int r = 0; r < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                if(nums.length == nums[r].length){
                    val = true;
                }
                else{
                    val = false;
                }
            }
        }
        return val;
    }

    public void addMatrix(int[][] other){
        for(int r = 0; r < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                nums[r][c] += other[r][c];
            }
        }
        print();
    }
    private void print(){
        for(int[] list: nums){
            System.out.print(Arrays.toString(list));
        }
    }

    public int columnSum(int col){
        int c = col; int sum = 0;
        for(int r = 0; r < nums.length; r++){
            sum += nums[r][c];
        }
        return sum;

    }
    public boolean isColumnMagic(){
        int sum = 0;
        int oldSum = sum;
        boolean isMagic = true;
        for (int c = 0; c < nums[0].length; c++){
            for (int r = 0; r < nums.length; r++){
                if (c < nums[r].length){
                    sum += nums[r][c];
                }
            }
            if (c > 1){
                if (sum != oldSum){
                    isMagic = false;
                }
            }
            oldSum = sum;
            sum = 0;
        }
        return isMagic;
    }
    public int diagDifference(){
        int diag1 = 0;
        int diag2 = 0;
        int c = 0;
        for (int r = 0; r < nums.length; r++)
        {
            diag1 += nums[r][c];
            c++;
        }
        c = nums[0].length - 1;
        for (int r = 0; r < nums.length; r++)
        {
            diag2 += nums[r][c];
            c--;
        }
        System.out.println(diag1 + " - " + diag2);
        int answer = Math.abs(diag1 - diag2);
        return answer;
    }
}