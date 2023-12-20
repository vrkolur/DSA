package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {

    public void findCombination(int idx, int[] arr, int target, List<List<Integer>> res, List<Integer> ans) {

        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (arr[i] > target)
                break;
            if (i > idx && arr[i] == arr[i - 1])
                continue;
            ans.add(arr[i]);
            findCombination(i + 1, arr, target - arr[i], res, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_Sum_II ob = new Combination_Sum_II();
        int arr[] = { 1, 1, 2, 2, 3, 3 };
        int target = 4;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        ob.findCombination(0, arr, target, res, new ArrayList<>());
        System.out.println(res);
    }
}
