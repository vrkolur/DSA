package Arrays;

import java.util.Arrays;

public class Three_Sum_Closest {

    private int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                final int sum = nums[i] + nums[l] + nums[r];
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
                if (sum > ans)
                    r--;
                else
                    l++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Three_Sum_Closest ob = new Three_Sum_Closest();
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println(ob.threeSumClosest(nums, target));
    }
}
