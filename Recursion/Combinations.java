package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    
    private void combinations(int n, int k,int start, List<List<Integer>> res, List<Integer> ans) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        // int current =counter;
        for (int i = start; i <=n; i++) {
            ans.add(i);
            combinations(n, k, i+1, res, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations ob = new Combinations();
        int n = 4, k = 2;
        List<List<Integer>> res = new ArrayList<>();
        ob.combinations(n, k, 0, res, new ArrayList<>());
        System.out.println(res);
    }
}
