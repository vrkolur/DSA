package Recursion;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

public class Permutation {

    public void permutation(String str, String per) {

        if (str.length() == 0) {
            System.out.println(per);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currchar = str.charAt(i);
            // 'abc' -> 'bc'
            String remaning = str.substring(0, i) + str.substring(i + 1);
            permutation(remaning, per + currchar);
        }
    }

    public void permutaionCase(String str, String newString) {
        if (str.length() == 0) {
            System.out.println(newString);
            return;
        }

        // char currChar = str.charAt(0);
        // String remaning = str.substring(1);

        // permutaionCase(remaning, newString+ currChar);
        // permutaionCase(remaning, newString + Character.toUpperCase(currChar));

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String remaning = str.substring(0, i) + str.substring(i + 1);
            permutaionCase(remaning, newString + currChar);
            permutaionCase(remaning, newString + Character.toUpperCase(currChar));
        }

    }

    public void permutation_Numbers(int[] arr, List<Integer> ans, List<List<Integer>> res) {
        if (ans.size() == arr.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (ans.contains(arr[i]))
                continue;
            ans.add(arr[i]);
            permutation_Numbers(arr, ans, res);
            ans.remove(ans.size() - 1);
        }
    }

    public  void permutaions_Numbers_Duplicate(int[] arr, List<Integer> ans, List<List<Integer>> res, boolean used[]) {

        if (ans.size() == arr.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i] || i > 1 && arr[i - 1] == arr[i] && !used[i - 1])
                continue;

            used[i] = true;
            ans.add(arr[i]);
            permutaions_Numbers_Duplicate(arr, ans, res, used);
            used[i] = false;
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation ob = new Permutation();
        String str = "abc";
        // int[] arr = { 1,2,3 };
        // String newstr = str.substring(0, 2) + str.substring(2 + 1);
        // System.out.println(newstr);
        ob.permutation(str, "");
        // ob.permutaionCase(str, "");
        // List<List<Integer>> res = new ArrayList<>();
        // ob.permutation_Numbers(arr, new ArrayList<>(), res);
        // sort arr before passing to permutaions_Numbers_Duplicate 
        // Arrays.sort(arr);
        // ob.permutaions_Numbers_Duplicate(arr, new ArrayList<>(), res, new boolean[arr.length]);
        // boolean[arr.length]);
        // System.out.println(res);
    }
}
