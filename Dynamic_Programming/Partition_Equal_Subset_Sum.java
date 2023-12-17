package Dynamic_Programming;

public class Partition_Equal_Subset_Sum {

    // This is recursive methon with time 2^n

    private boolean recursive(int[] arr, int n, int sum) {

        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        if (arr[n - 1] <= sum)
            return recursive(arr, n - 1, sum - arr[n - 1]) || recursive(arr, n - 1, sum);
        else
            return recursive(arr, n - 1, sum);
    }

    // Using a Dynamic Approach
    // Look at the book for the approach| connection to the problem Subset Sum
    // Problem.

    private boolean dynamic(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            t[i][0] = true;
        for (int i = 1; i <= sum; i++)
            t[0][i] = false;

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

    // Now since we use onlu the previous row to calculate the current row we will
    // space opetimisize code.

    private boolean partition(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        boolean[] t = new boolean[sum + 1];
        t[0] = true;
        for (int num : arr) {
            for (int i = sum; i >= num; i--) {
                t[i] = t[i] || t[i - num];
            }
        }
        return t[sum];
    }

    public static void main(String[] args) {
        Partition_Equal_Subset_Sum ob = new Partition_Equal_Subset_Sum();
        int[] arr = { 1, 5, 5, 11 };
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 == 0)
            System.out.println(ob.recursive(arr, arr.length, sum / 2));
        else
            System.out.println(false);
        System.out.println(ob.dynamic(arr));
        System.out.println(ob.partition(arr));
    }
}
