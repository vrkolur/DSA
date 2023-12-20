package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1239 {
    static int maxlen = 0;

    private boolean isUnique(String newString) {
        int[] check = new int[26];
        for (int i = 0; i < newString.length(); i++) {
            check[newString.charAt(i) - 'a']++;
            if (check[newString.charAt(i) - 'a'] > 1)
                return false;
        }
        return true;
    }


    private void backtrack(List<String> arr, String newString, int idx) {
        if (!isUnique(newString))
            return;
        if (idx == arr.size()) {
            if (isUnique(newString)) {
                maxlen = Math.max(maxlen, newString.length());
                // System.out.println(newString);
                // System.out.println(maxlen);
                return;
            }
        }

        String current = arr.get(idx);
        backtrack(arr, newString + current, idx + 1);
        backtrack(arr, newString, idx + 1);
    }

    public static void main(String[] args) {
        Leetcode_1239 ob = new Leetcode_1239();
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        ob.backtrack(arr, "", 0);
        System.out.println(maxlen);
    }
}
