package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Common_Subsequence {

    // This is the recursive function O(n^m*n)

    private int lcs(String x, String y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (x.charAt(m - 1) == y.charAt(n - 1))
            return 1 + lcs(x, y, m - 1, n - 1);
        else
            return Math.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
    }

    private int lcs(String x, String y, int m, int n, int[][] dp) {

        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (x.charAt(m - 1) == y.charAt(n - 1))
            return dp[m][n] = 1 + lcs(x, y, m - 1, n - 1, dp);

        else
            return dp[m][n] = Math.max(lcs(x, y, m - 1, n, dp), lcs(x, y, m, n - 1, dp));
    }

    // Top-Down Approach

    private int lcs(String x, String y) {

        int m = x.length();
        int n = y.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[m][n];
    }

    // Printing longest subsequence

    private String lcsPrint(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        StringBuilder s = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                s.append(x.charAt(i - 1));
                i--;
                j--;  
            } else if (t[i - 1][j] > t[i][j - 1])
                i--;
            else
                j--;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Longest_Common_Subsequence ob = new Longest_Common_Subsequence();
        // String x = "AGGTAB";
        // String y = "GXTXAYB";
        String x = "acbea";
        String y = "zaabq";
        int m = x.length(), n = y.length();
        System.out.println(ob.lcs(x, y, m, n));
        int[][] dp = new int[m + 1][n + 1];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        System.out.println(ob.lcs(x, y, m, n, dp));
        System.out.println(ob.lcs(x, y));
        System.out.println(ob.lcsPrint(x, y));
        System.gc();
    }
}
