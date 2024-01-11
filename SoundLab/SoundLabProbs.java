public class SoundLabProbs{
    public SoundLabProbs(){}

    public int lastIndexOf(int[] nums, int value){
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == value){
                temp = i;
            }
            else{
                temp = -1;
            }
        }
        return temp;
    }
    public int range(int[] nums){
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return (max - min);
    }
    public int minDifference(int[] nums){
        int val = Math.abs(nums[0]-nums[1]);
        for (int i =0; i< nums.length-1; i++)
        {
            if(Math.abs(nums[i]-nums[i + 1]) >= 0 && Math.abs(nums[i] - nums[i + 1]) < val)
                val = Math.abs(nums[i] - nums[i + 1]);
        }
        return val;
    }

    public String reverseWords(String str){
        String[] sent = str.split("//s");
        String output = "";

        for (int i = 0; i < sent.length; i++){
            String w = sent[i];
            String r = "";
            for (int j = w.length() - 1; j >= 0; j--) {
                r = r + w.charAt(j);
            }
            output += r + " ";
        }

        return output;
    }
    public int priceIsRight(int[] bids, int price){
        int winner = -1;
        int diff = price;
        for(int i = 0; i < bids.length; i++){
            if(bids[i] > price){
                continue;
            }
            else{
                if(price - bids[i] <= diff){
                    winner = bids[i];
                    diff = price - bids[i];
                }
            }
        }
        return winner;
    }
    public int[] productExceptSelf(int[] nums){
        int val = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            val = 1;
            for (int x = 0; x < nums.length; x++)
            {
                if (x == i)
                    continue;
                else
                    val *= nums[x];
            }
            result[i] = val;
        }
        return result;
    }
}

