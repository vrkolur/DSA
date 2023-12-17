package Dynamic_Programming;

public class Longest_Common_Substring {

    private int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] t = new int[m + 1][n + 1];

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                    res = Math.max(res, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Longest_Common_Substring ob = new Longest_Common_Substring();
        String x = "asdfsdf";
        String y = "asdfxcvb";
        System.out.println(ob.lcs(x, y));
        System.gc();
    }
}
