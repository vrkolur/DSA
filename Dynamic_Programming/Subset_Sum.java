package Dynamic_Programming;

public class Subset_Sum {

    // This is the recursive approach
    private boolean subset(int idx, int target, int[] nums) {
        if (target == 0)
            return true;
        if (idx == 0)
            return (target == nums[0]);
        // Not take it
        boolean notTake = subset(idx - 1, target, nums);
        boolean take = false;
        if (target >= nums[idx]) {
            take = subset(idx - 1, target - nums[idx], nums)|| subset(idx-1, target, nums);
        }

        return (notTake || take);
    }

    private boolean subset(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            t[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        Subset_Sum ob = new Subset_Sum();
        int[] arr = { 2, 3, 7, 12, 10 };
        int sum = 14;
        System.out.println(ob.subset(arr.length-1, sum, arr));
        System.out.println(ob.subset(arr, sum));
        System.gc();
    }
}
