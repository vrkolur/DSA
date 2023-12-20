package Recursion;

import java.util.ArrayList;
// import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subset_Sum {

    private void solution(int idx, int sum, int[] arr, Set<Integer> res) {
        if (idx == arr.length) {
            if (res.contains(sum))
                return;
            else
                res.add(sum);
            return;
        }
        // pick the element
        solution(idx + 1, sum + arr[idx], arr, res);

        // Don't add to the sum
        solution(idx + 1, sum, arr, res);
    }

    private void solveSUbsets(int idx, int[] arr, List<Integer> ans,List<List<Integer>> res) {

        res.add(new ArrayList<>(ans));

        for (int i = idx; i < arr.length; i++) {
            ans.add(arr[i]);
            solveSUbsets(i + 1, arr, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset_Sum ob = new Subset_Sum();
        int[] arr = { 1, 2, 3 };
        // List<Integer> res = new ArrayList<>();
        Set<Integer> res = new HashSet<>();
        ob.solution(0, 0, arr, res);
        // Collections.sort(res);
        System.out.println(res);
        List<List<Integer>> result = new ArrayList<>();
        ob.solveSUbsets(0, arr, new ArrayList<>(), result);
        System.out.println(result);
    }
}
