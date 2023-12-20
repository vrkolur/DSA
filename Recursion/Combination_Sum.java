package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {

    public void findSum(int idx, int[] arr, int target, List<List<Integer>> res, List<Integer> ans) {

        if (idx == arr.length) {
            if (target == 0) {
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        if (arr[idx] <= target) {
            ans.add(arr[idx]);
            findSum(idx, arr, target - arr[idx], res, ans);
            ans.remove(ans.size() - 1);
        }
        findSum(idx + 1, arr, target, res, ans);
    }

    public static void main(String[] args) {
        Combination_Sum ob = new Combination_Sum();
        int arr[] = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> res = new ArrayList<>();
        ob.findSum(0, arr, target, res, new ArrayList<>());
        System.out.println(res);
    }
}
