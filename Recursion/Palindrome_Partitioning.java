package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {

    private void solve(int idx, String str, List<String> ans, List<List<String>> res) {
        if (idx == str.length()) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            if (isPalindrome(str, idx, i)) {
                ans.add(str.substring(idx, i +1));
                solve(i+1, str, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Palindrome_Partitioning ob = new Palindrome_Partitioning();
        String str = "aabb";
        List<List<String>> res = new ArrayList<>();
        ob.solve(0, str, new ArrayList<>(), res);
        System.out.println(res);
    }

}
