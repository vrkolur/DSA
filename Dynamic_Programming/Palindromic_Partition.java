package Dynamic_Programming;

import java.util.Arrays;

public class Palindromic_Partition {

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }

    private int minPartition(String str, int i, int j) {

        if (i >= j || isPalindrome(str, i, j))
            return 0;

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            ans = Math.min(ans, minPartition(str, i, k)
                    + minPartition(str, k + 1, j) + 1);
        }
        return ans;
    }

    private int minPartition(String str, int i, int j, int[][] t) {
        if (i >= j || isPalindrome(str, i, j))
            return 0;
        if (t[i][j] != -1)
            return t[i][j];
        t[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            t[i][j] = Math.min(t[i][j], minPartition(str, i, k, t) + minPartition(str, k + 1, j, t));
        }
        return t[i][j];
    }

    public static void main(String[] args) {
        Palindromic_Partition ob = new Palindromic_Partition();
        String str = "nitin";
        System.out.println(ob.minPartition(str, 0, str.length() - 1));
        int n = str.length();
        int[][] t = new int[n + 1][n + 1];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.minPartition(str, 0, n - 1, t));
    }
}
