package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class Minimum_subset_sum_Difference {
    // Minimum subset sum Difference.
    // This code will not work in Leetcode fpr that Different solution
    // This is the recursive method use the recursive tree.
    private int recursive(int[] arr, int idx, int sum, int total) {
        if (idx == 0)
            return Math.abs(total - 2 * sum);

        return Math.min(recursive(arr, idx - 1, sum + arr[idx], total), recursive(arr, idx - 1, sum, total));
    }

    // This is a Dynamic Process. For full explanition see the dp notes.

    private int findMin(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int num : arr)
            sum += num;
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            t[0][i] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        List<Integer> res = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        for (int i = sum / 2; i >= 0; i--) {
            if (t[n][i]) {
                res.add(i);
            }
        }

        // System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            ans = Math.min(ans, sum - 2 * res.get(i));
        }
        return ans;
    }

    private int findMin1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        boolean[][] t = new boolean[n + 1][sum / 2 + 1];
        for (int i = 0; i <= n; i++)
            t[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (nums[i - 1] <= j)
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        if (sum % 2 == 0 && t[n][sum / 2]) {
            // System.out.println("Yes");
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        for (int j = sum / 2; j >= 0; j--)
            if (t[n][j])
                res.add(j);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            ans = Math.min(ans, sum - 2 * res.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Minimum_subset_sum_Difference ob = new Minimum_subset_sum_Difference();
        // int[] nums = { 5,11,6,1 };
        int[] nums = { 1, 2, 3, 4, 5 };
        int total = 0;
        for (int x : nums)
            total += x;
        // System.out.println(total);
        System.out.println(ob.recursive(nums, nums.length - 1, 0, total));
        System.out.println(ob.findMin(nums));
        System.out.println(ob.findMin1(nums));
        System.gc();
    }
}
