package Dynamic_Programming;

import java.util.Arrays;

public class Maximize_The_Cut_Segments {

    // this is the recursive approach

    private int cutSegments(int l, int p, int q, int r) {

        if (l == 0)
            return 0;
        if (l < 0)
            return Integer.MIN_VALUE;

        int a = cutSegments(l - p, p, q, r) + 1;
        int b = cutSegments(l - q, p, q, r) + 1;
        int c = cutSegments(l - r, p, q, r) + 1;

        return Math.max(a, Math.max(b, c));
    }

    private int cutSections(int l, int p, int q, int r, int[] dp) {
        if (l == 0)
            return 0;
        if (dp[l] != -1)
            return dp[l];

        int a = Integer.MIN_VALUE, b, c;
        b = a;
        c = a;

        if (p <= l)
            a = 1 + cutSections(l - p, p, q, r, dp);
        if (q <= l)
            b = 1 + cutSections(l - q, p, q, r, dp);
        if (r <= l)
            c = 1 + cutSections(l - r, p, q, r, dp);

        return dp[l] =  Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Maximize_The_Cut_Segments ob = new Maximize_The_Cut_Segments();
        int l = 7, p = 2, q = 5, r = 5;
        System.out.println(ob.cutSegments(l, p, q, r));
        int[] dp = new int[l + 1];
        Arrays.fill(dp, -1);
        System.out.println(ob.cutSections(l, p, q, r, dp));
        System.gc();
    }
}
