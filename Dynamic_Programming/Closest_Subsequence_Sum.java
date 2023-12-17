// package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Closest_Subsequence_Sum {

    private List<Integer> generate(int[] nums, int start, int end, int offset) {
        List<Integer> res = new ArrayList<>();
        int n = end - start + 1;
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j))
                    sum += nums[j + offset];
            }
            res.add(sum);
        }
        return res;
    }

    private int minAbsDifference(int[] nums, int goal) {
        List<Integer> firstHalf = new ArrayList<>();
        List<Integer> secondHalf = new ArrayList<>();

        generate(nums,firstHalf, 0, n / 2, 0);
        generate(nums,secondHalf, n / 2, n-1, n / 2);

        Collections.sort(firstHalf);
        int ans = Integer.MAX_VALUE;
        for (int secondSetSum : secondHalf) {
            int left = goal - secondSetSum;
            
        }

    }

    public static void main(String[] args) {
        Closest_Subsequence_Sum ob = new Closest_Subsequence_Sum();
        int[] nums = { 7, -9, 15, -2 };
        // System.out.println(1<<10);
    }
}
