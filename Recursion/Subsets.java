package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public void solve(int idx, int arr[], List<Integer> ans, List<List<Integer>> res) {
        res.add(new ArrayList<>(ans));

        for (int i = idx; i < arr.length; i++) {
            ans.add(arr[i]);
            solve(i + 1, arr, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public void solveDuplicate(int idx, int arr[], List<Integer> ans, List<List<Integer>> res) {
        res.add(new ArrayList<>(ans));

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i - 1] == arr[i])
                continue;
            ans.add(arr[i]);
            solveDuplicate(i + 1, arr, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets ob = new Subsets();
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> res = new ArrayList<>();
        ob.solve(0, arr, new ArrayList<>(), res);
        System.out.println(res);
        // List<List<Integer>> res1=new ArrayList<>();
        // ob.solveDuplicate(0, arr, new ArrayList<>(), res1);
        // System.out.println(res1);
    }
}
