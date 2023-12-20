package Recursion;

import java.util.Arrays;

public class Partition_to_K_Equal_Sum_Subsets {
    int arr[] = { 1,2,3,4 };
    int k = 3;
    boolean[] used = new boolean[arr.length];
    int sum = Arrays.stream(arr).sum();
    int target = sum / k;

    private boolean checkPartition(int idx, int k, int subsetSum) {
        if (k == 0)
            return true;
        if (subsetSum == target)
            return checkPartition(0, k - 1, 0);

        for (int i = idx; i < arr.length; i++) {
            if (used[i] && arr[i] + subsetSum > target) {
                continue;
            }
            used[i] = true;
            if (checkPartition(i + 1, k, subsetSum + arr[i]))
                return true;
            used[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Partition_to_K_Equal_Sum_Subsets ob = new Partition_to_K_Equal_Sum_Subsets();
        System.out.println(ob.checkPartition(0, 4, 0));
    }
}
