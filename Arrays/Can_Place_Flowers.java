package Arrays;

public class Can_Place_Flowers {

    private boolean canPlaceFlowers(int[] nums, int count) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[0] == 0 && nums[1] == 0) {
                    nums[0] = 1;
                    count--;
                }
                continue;
            }
            if (i == n - 1) {
                if (nums[n - 1] == 0 && nums[n - 2] == 0) {
                    nums[n - 1] = 1;
                    count--;
                }
                continue;
            }
            if (i < n - 1 && i>0&& nums[i] == 0 && nums[i - 1] == 0 && nums[i + 1] == 0) {
                nums[i] = 1;
                count--;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        Can_Place_Flowers ob = new Can_Place_Flowers();
        int[] nums = { 0, 0, 0, 0, 0, 1 };
        int n = 2;
        System.out.println(ob.canPlaceFlowers(nums, n));
    }
}
