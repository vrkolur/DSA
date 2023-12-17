package Dynamic_Programming;


public class House_Robber_II {

    // In this one all the Houses are connected in a circle, hence we cannot select
    // the first and the last at a time
    // The last House is adjscent of the firstone.

    private int robII(int[] nums) {
        House_Robber ob1 = new House_Robber();
        int n=nums.length;
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];
        int count1=0,count2=0;
        for (int i = 0; i < n; i++) {
            if (i != 0)
                temp1[count1++] = nums[i];
            if (i != n - 1)
                temp2[count2++] = nums[i];
        }
        return Math.max(ob1.rob(temp1), ob1.rob(temp2));
    }


    public static void main(String[] args) {
        House_Robber_II ob = new House_Robber_II();
        int[] nums = { 2, 3, 2 };
        System.out.println(ob.robII(nums));
    }
}
