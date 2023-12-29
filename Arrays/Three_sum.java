package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Three_sum {

    // Time limit exeded.
    private List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    // set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        for (List<Integer> it : set)
            res.add(it);
        return res;
    }

    private List<List<Integer>> threesum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        final int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if (i==0 || (i > 0 && nums[i - 1] != nums[i])) {
                int l = i + 1;
                int r = n - 1;
                int sum = 0-nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        while (l < r && nums[r] == nums[r - 1])
                            r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] > sum)
                        r--;
                    else
                        l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Three_sum ob = new Three_sum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(ob.threeSum(nums));
        System.out.println(ob.threesum1(nums));
    }
}
