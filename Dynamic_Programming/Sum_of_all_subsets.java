// package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class Sum_of_all_subsets {
    // This problem is the same as Recursion.Subset_sum
    // Here we will DP to solve the problem but will take a bit of space still
    // better than the stack memory of the recursive approach

    private List<Integer> subsetSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int x : arr)
            sum += x;
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            t[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= sum; i++) {
            if (t[n][i])
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Sum_of_all_subsets ob = new Sum_of_all_subsets();
        int[] arr = { 1, 2, 3 };
        System.out.println(ob.subsetSum(arr));
        System.gc();
    }
}
